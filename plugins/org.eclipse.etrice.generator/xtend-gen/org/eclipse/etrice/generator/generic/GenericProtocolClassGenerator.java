package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GenericProtocolClassGenerator {
  @Inject
  private ILanguageExtension langExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  public String genMessageIDs(final ProtocolClass pc) {
      int offset = 0;
      ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
      ArrayList<Pair<String,String>> list = _arrayList;
      String _name = pc.getName();
      String _memberInDeclaration = this.langExt.memberInDeclaration(_name, "MSG_MIN");
      String _string = ((Integer)offset).toString();
      Pair<String,String> _pair = Tuples.<String, String>pair(_memberInDeclaration, _string);
      list.add(_pair);
      List<Message> _allOutgoingMessages = this.roomExt.getAllOutgoingMessages(pc);
      for (final Message msg : _allOutgoingMessages) {
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)1));
          offset = _operator_plus;
          String _name_1 = pc.getName();
          String _name_2 = msg.getName();
          String _operator_plus_1 = StringExtensions.operator_plus("OUT_", _name_2);
          String _memberInDeclaration_1 = this.langExt.memberInDeclaration(_name_1, _operator_plus_1);
          String _string_1 = ((Integer)offset).toString();
          Pair<String,String> _pair_1 = Tuples.<String, String>pair(_memberInDeclaration_1, _string_1);
          list.add(_pair_1);
        }
      }
      List<Message> _allIncomingMessages = this.roomExt.getAllIncomingMessages(pc);
      for (final Message msg_1 : _allIncomingMessages) {
        {
          int _operator_plus_2 = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)1));
          offset = _operator_plus_2;
          String _name_3 = pc.getName();
          String _name_4 = msg_1.getName();
          String _operator_plus_3 = StringExtensions.operator_plus("IN_", _name_4);
          String _memberInDeclaration_2 = this.langExt.memberInDeclaration(_name_3, _operator_plus_3);
          String _string_2 = ((Integer)offset).toString();
          Pair<String,String> _pair_2 = Tuples.<String, String>pair(_memberInDeclaration_2, _string_2);
          list.add(_pair_2);
        }
      }
      int _operator_plus_4 = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)1));
      offset = _operator_plus_4;
      String _name_5 = pc.getName();
      String _memberInDeclaration_3 = this.langExt.memberInDeclaration(_name_5, "MSG_MAX");
      String _string_3 = ((Integer)offset).toString();
      Pair<String,String> _pair_3 = Tuples.<String, String>pair(_memberInDeclaration_3, _string_3);
      list.add(_pair_3);
      String _name_6 = pc.getName();
      String _memberInDeclaration_4 = this.langExt.memberInDeclaration(_name_6, "msg_ids");
      String _genEnumeration = this.langExt.genEnumeration(_memberInDeclaration_4, list);
      return _genEnumeration;
  }
  
  public String getMessageID(final MessageFromIf mif) {
    Message _message = mif.getMessage();
    InterfaceItem _from = mif.getFrom();
    String _messageID = this.getMessageID(_message, _from);
    return _messageID;
  }
  
  public String getMessageID(final Message msg, final InterfaceItem item) {
      if ((item instanceof Port)) {
        {
          Port p = ((Port) item);
          String _xifexpression = null;
          boolean _isConjugated = p.isConjugated();
          if (_isConjugated) {
            _xifexpression = "OUT_";
          } else {
            _xifexpression = "IN_";
          }
          String direction = _xifexpression;
          ProtocolClass _protocol = p.getProtocol();
          String _name = _protocol.getName();
          String _name_1 = msg.getName();
          String _operator_plus = StringExtensions.operator_plus(direction, _name_1);
          String _memberInUse = this.langExt.memberInUse(_name, _operator_plus);
          return _memberInUse;
        }
      } else {
        if ((item instanceof SAPRef)) {
          {
            SAPRef sap = ((SAPRef) item);
            ProtocolClass _protocol_1 = sap.getProtocol();
            String _name_2 = _protocol_1.getName();
            String _name_3 = msg.getName();
            String _operator_plus_1 = StringExtensions.operator_plus("OUT_", _name_3);
            String _memberInUse_1 = this.langExt.memberInUse(_name_2, _operator_plus_1);
            return _memberInUse_1;
          }
        } else {
          if ((item instanceof SPPRef)) {
            {
              SPPRef spp = ((SPPRef) item);
              ProtocolClass _protocol_2 = spp.getProtocol();
              String _name_4 = _protocol_2.getName();
              String _name_5 = msg.getName();
              String _operator_plus_2 = StringExtensions.operator_plus("IN_", _name_5);
              String _memberInUse_2 = this.langExt.memberInUse(_name_4, _operator_plus_2);
              return _memberInUse_2;
            }
          }
        }
      }
      return "unknown interface item";
  }
}
