package org.eclipse.etrice.expressions.detailcode

import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.SPP
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Defines expression that does not have an model representation. Extends {@link DefaultDetailExpressionProvider} 
 */
@FinalFieldsConstructor
class RuntimeDetailExpressionProvider extends DefaultDetailExpressionProvider {

	public static val RT_METHOD_GET_REPLICATION = "getReplication"

	@Accessors
	static class RuntimeMethodExpressionData {
		//val String methodName
		//EObject eObj
	}

	override getContextFeatures(ExpressionFeature ctx) {
		val scope = super.getContextFeatures(ctx)

		switch obj : ctx.data {
			InterfaceItem: {
				if (ctx.postfix == ExpressionPostfix.NONE) {
					switch obj {
						Port case obj.replicated/* fall through */,
						SPP: {
							// not supported yet by code translation
							//scope += createRtMethodExprFeature(RT_METHOD_GET_REPLICATION, obj)
						}
					}
				}
			}
		}

		return scope
	}

	protected def createRtMethodExprFeature(String methodName, EObject eObj) {
		val feature = new ExpressionFeature(methodName, ExpressionPostfix.PARENTHESES)
		feature.data = new RuntimeMethodExpressionData()

		return feature
	}

}
