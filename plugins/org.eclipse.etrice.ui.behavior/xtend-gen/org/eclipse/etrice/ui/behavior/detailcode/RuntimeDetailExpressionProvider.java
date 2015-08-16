package org.eclipse.etrice.ui.behavior.detailcode;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.ui.behavior.detailcode.DefaultDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

/**
 * Defines expression that does not have an model representation. Extends {@link DefaultDetailExpressionProvider}
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RuntimeDetailExpressionProvider extends DefaultDetailExpressionProvider {
  @Accessors
  public static class RuntimeMethodExpressionData {
  }
  
  public final static String RT_METHOD_GET_REPLICATION = "getReplication";
  
  public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
    final List<IDetailExpressionProvider.ExpressionFeature> scope = super.getContextFeatures(ctx);
    Object _data = ctx.getData();
    final Object obj = _data;
    boolean _matched = false;
    if (!_matched) {
      if (obj instanceof InterfaceItem) {
        _matched=true;
        IDetailExpressionProvider.ExpressionPostfix _postfix = ctx.getPostfix();
        boolean _equals = Objects.equal(_postfix, IDetailExpressionProvider.ExpressionPostfix.NONE);
        if (_equals) {
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (obj instanceof Port) {
              boolean _isReplicated = ((Port)obj).isReplicated();
              if (_isReplicated) {
                _matched_1=true;
              }
            }
            if (!_matched_1) {
              if (obj instanceof SPP) {
                _matched_1=true;
              }
            }
            if (_matched_1) {
            }
          }
        }
      }
    }
    return scope;
  }
  
  protected IDetailExpressionProvider.ExpressionFeature createRtMethodExprFeature(final String methodName, final EObject eObj) {
    final IDetailExpressionProvider.ExpressionFeature feature = new IDetailExpressionProvider.ExpressionFeature(methodName, IDetailExpressionProvider.ExpressionPostfix.PARENTHESES);
    RuntimeDetailExpressionProvider.RuntimeMethodExpressionData _runtimeMethodExpressionData = new RuntimeDetailExpressionProvider.RuntimeMethodExpressionData();
    feature.setData(_runtimeMethodExpressionData);
    return feature;
  }
  
  public RuntimeDetailExpressionProvider(final ActorClass actorClass) {
    super(actorClass);
  }
}
