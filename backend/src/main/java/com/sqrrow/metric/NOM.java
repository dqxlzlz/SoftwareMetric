package com.sqrrow.metric;

import com.sqrrow.entity.*;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class NOM extends ASTVisitor implements Metric {

	private int methods;

	@Override
	public boolean visit(MethodDeclaration node) {
		methods++;

		return false;
	}

	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNom(methods);
	}
}
