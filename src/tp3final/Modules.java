package tp3final; 

//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.agent.mo.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.smi.OctetString;


//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class Modules implements MOGroup {

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(Modules.class);

  private MerstelGrMib merstelGrMib;

  private MOFactory factory;

//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  public Modules() {
   merstelGrMib = new MerstelGrMib(); 
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  public Modules(MOFactory factory) {
   merstelGrMib = new MerstelGrMib(factory); 
//--AgentGen BEGIN=_CONSTRUCTOR
//--AgentGen END
  } 

  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
	  merstelGrMib.registerMOs(server, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
	  merstelGrMib.unregisterMOs(server, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  public MerstelGrMib getMerstelGrMib() {
    return merstelGrMib;
  }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END

}

