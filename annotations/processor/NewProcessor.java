package processor;

import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import javax.lang.model.SourceVersion;

public class NewProcessor extends AbstractProcessor {
	@Override
	public synchronized void init (ProcessingEnvironment env) {}

	@Override
	public boolean process (Set<? extends TypeElement> annotations,
							RoundEnvironment env) {}

	@Override
	public Set<String> getSupportedAnnotationTypes() {}

	@Override
	public SourceVersion getSupportedSourceVersion() {}
} 
