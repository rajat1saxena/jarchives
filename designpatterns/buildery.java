/*
* This examples assembles a custom phone having different
* components based on builder pattern.
*/
class CustomPhone{
	// required parameters
	public String processor;
	public int ppi;

	// optional parameters
	public boolean bluetooth;
	public boolean camera;
	public boolean rearcamera;
	public boolean networklte;
	public boolean networkgsm;
	public boolean networkcdma;
	public String gpu;

	@Override
	public String toString(){
		return "Phone config: " + processor + "; " + ppi;
	}

	public static class Builder{
		// required parameters
		private String processor;
		private int ppi;
		// optional parameters
		private boolean bluetooth;
		private boolean camera;
		private boolean rearcamera;
		private boolean networklte;
		private boolean networkgsm;
		private boolean networkcdma;
		private String gpu;

		// initialize required parameters using constructor
		public Builder(String processor, int ppi){
			this.processor = processor;
			this.ppi = ppi;
		}

		// initialize all optional parameters
		public Builder addBluetooth(){
			this.bluetooth = bluetooth;
			return this;
		}
		public Builder addCamera(){
			this.camera = camera;
			return this;
		}
		public Builder addRearCamera(){
			this.rearcamera = rearcamera;
			return this;
		}
		public Builder addNetworkLTE(){
			this.networklte = networklte;
			return this;
		}
		public Builder addNetworkGsm(){
			this.networkgsm = networkgsm;
			return this;
		}
		public Builder addNetworkCdma(){
			this.networkcdma = networkcdma;
			return this;
		}
		public Builder addGpu(String gpu){
			this.gpu = gpu;
			return this;
		}

		// Build the object
		public CustomPhone build(){
			CustomPhone p = new CustomPhone();
			p.processor = this.processor;
			p.ppi = this.ppi;
			p.bluetooth = this.bluetooth;
			p.camera = this.camera;
			p.networklte = this.networklte;
			p.networkgsm = this.networkgsm;
			p.networkcdma = this.networkcdma;
			p.gpu = this.gpu;

			return p;
		}
	}
}

public class buildery{
	public static void main(String args[]){
		// Build two custom phone
		CustomPhone x = new CustomPhone.Builder("Dual core",221)
			.addCamera()
			.addGpu("Adreno 302")
			.addNetworkLTE()
			.build();

		System.out.println(x.toString());

		CustomPhone y = new CustomPhone.Builder("Mediatek",320)
			.addCamera()
			.addNetworkCdma()
			.build();

		System.out.println(y.toString());
	}
}