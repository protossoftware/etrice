
package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions

	def genHeaderConstants(ExpandedActorClass xpac) {

	}
	
	def genDataMembers(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
	'''
		/* state machine variables */
		int m_state;
		int m_history[«ac.name.toUpperCase»_HISTORY_SIZE];
	'''}
	
	def genInitialization(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
	'''
		m_state = STATE_TOP;
		{
			int i;
			for (i=0; i<«ac.name.toUpperCase»_HISTORY_SIZE; ++i)
				m_history[i] = NO_STATE;
		}
		executeInitTransition();
	'''}
	override genExtra(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
	'''
		// state names
		protected:
		 static std::string stateStrings[] = {"<no state>","<top>",«FOR state : ac.getAllBaseStatesLeavesLast() SEPARATOR ","»"«state.getStatePathName()»"
		«ENDFOR»};
		
«««	 	TODOHRR: history defined in ActorClassBase, init in constructor
«««			history = new int[5];
«««			for (int i = 0; i < history.length; i++) {
«««				history[i] = NO_STATE;
«««			}
		// history
		protected:
		int history[] = {NO_STATE,NO_STATE«FOR state : ac.getAllBaseStates()»,NO_STATE«ENDFOR»};
		
		private:
		void setState(int new_state) {
			DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
			if (stateStrings[new_state]!="Idle") {
«««				TODOTS: model switch for activation
				std::cout << getInstancePath() << " -> " << stateStrings[new_state] << std::endl;
			}	
			m_state = new_state;
		}
	'''}
}
