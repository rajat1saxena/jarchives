/**
* This program demonstrated the 'Strategy Enum Pattern' where
* one can pass enum as the strategy to define constant-specific 
* behavior on enums.
*
* Read: Effective Java (Item 30)
*
* This pattern forces us to pass a strategy to calculate the pay
* so that we DO NOT forget that while adding a new enum type.
*/
final class StrategyEnumDriver {
	private static enum PayrollDay {
		MONDAY(PayType.WEEKDAY), 
		TUESDAY(PayType.WEEKDAY),
		WEDNESDAY(PayType.WEEKDAY),
		THURSDAY(PayType.WEEKDAY),
		FRIDAY(PayType.WEEKDAY),
		SATURDAY(PayType.WEEKEND),
		SUNDAY(PayType.WEEKEND);

		private final PayType payType;

		PayrollDay(PayType payType) { this.payType = payType; }
		
		/**
		* Returns total pay for the day.
		* 
		* @param hoursWorked total number of hours an employee worked
		* @param payRate pay rate for the employee
		* @return total amount to be paid to the employee
		*/
		double pay(int hoursWorked, double payRate) {
			return payType.pay(hoursWorked, payRate);
		}

		/**
		* Pay type
		*/
		private static enum PayType {
			WEEKDAY {
				@Override
				double overtimePay(int hours, double rate) {
					return hours <= HOURS_PER_SHIFT ? 0:
						(hours - HOURS_PER_SHIFT) * rate/2;	
				}
			},
			WEEKEND {
				@Override
				double overtimePay (int hours, double rate) {
					return hours * rate/2;
				}
			};

			// Minimum number of hours an employee has to work for
			private static final int HOURS_PER_SHIFT = 8;

			/**
			* Returns overtime pay.
			*/
			abstract double overtimePay(int hours, double rate);

			/**
			* Return total amount to be paid the employee. The amount
			* to be paid is calculated by the formula
			* {@code hours * rate + overtimePay(hours, rate) }.
			*
			* @param hours total hours worked by employee
			* @param rate rate by which the employee is paid
			* @return total amount to be paid 
			*/
			double pay(int hours, double rate) {
				double basePay = hours * rate;
				return basePay + overtimePay(hours, rate);
			}
		}
	}

	public static void main(String args[]) {
		// Print pay for all days for an employee whose payrate is 
		// $2/hour.
		for (PayrollDay pd: PayrollDay.values()) {
			System.out.printf("%s: %f%n", pd, pd.pay(9, 2));
		}
	}
}
