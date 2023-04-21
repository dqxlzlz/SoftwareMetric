package org.csu.metrics.metric;

import org.csu.metrics.CKNumber;
import org.csu.metrics.CKReport;
import org.eclipse.jdt.core.dom.CompilationUnit;

public interface Metric {

	void execute(CompilationUnit cu, CKNumber result, CKReport report);
	void setResult(CKNumber result);
}
