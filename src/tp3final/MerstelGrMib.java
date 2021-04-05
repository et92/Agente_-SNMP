package tp3final;  

//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.agent.request.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.mo.snmp.tc.*;



//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class MerstelGrMib 
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
implements MOGroup 
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(MerstelGrMib.class);

//--AgentGen BEGIN=_STATIC
//--AgentGen END

  // Factory
  private MOFactory moFactory = 
    DefaultMOFactory.getInstance();

  // Constants 

  /**
   * OID of this MIB module for usage which can be 
   * used for its identification.
   */
  public static final OID oidMerstelGrMib =
    new OID(new int[] { 1,3,6,1,3,8888 });

  // Identities
  // Scalars
  // Tables

  // Notifications
  public static final OID oidMerstelMIBNotification =
    new OID(new int[] { 1,3,6,1,3,8888,2,1 });   
  public static final OID oidTrapVarMerstelMIBType =
    new OID(new int[] { 1,3,6,1,3,8888,1,1,1,1 });
  public static final OID oidTrapVarMerstelMIBIdentityevent =
    new OID(new int[] { 1,3,6,1,3,8888,1,1,1,7 });


  // Enumerations




  // TextualConventions
  private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
  private static final String TC_DISPLAYSTRING = "DisplayString";

  // Scalars

  // Tables
  public static final OID oidMerstelMIBEntry = 
    new OID(new int[] { 1,3,6,1,3,8888,1,1,1 });

  // Index OID definitions
  public static final OID oidMerstelMIBType =
    new OID(new int[] { 1,3,6,1,3,8888,1,1,1,1 });
  public static final OID oidMerstelMIBIdentityevent =
    new OID(new int[] { 1,3,6,1,3,8888,1,1,1,7 });

  // Column TC definitions for merstelMIBEntry:
  public static final String tcModuleSNMPv2Tc = "SNMPv2-TC";
  public static final String tcDefDisplayString = "DisplayString";
    
    // Column sub-identifier definitions for merstelMIBEntry:
    public static final int colMerstelMIBType = 1;
    public static final int colMerstelMIBYear = 2;
    public static final int colMerstelMIBWeek = 3;
    public static final int colMerstelMIBDay = 4;
    public static final int colMerstelMIBHour = 5;
    public static final int colMerstelMIBMinute = 6;
    public static final int colMerstelMIBIdentityevent = 7;

    // Column index definitions for merstelMIBEntry:
    public static final int idxMerstelMIBType = 0;
    public static final int idxMerstelMIBYear = 1;
    public static final int idxMerstelMIBWeek = 2;
    public static final int idxMerstelMIBDay = 3;
    public static final int idxMerstelMIBHour = 4;
    public static final int idxMerstelMIBMinute = 5;
    public static final int idxMerstelMIBIdentityevent = 6;

  private MOTableSubIndex[] merstelMIBEntryIndexes;
  private MOTableIndex merstelMIBEntryIndex;

    @SuppressWarnings(value={"rawtypes"})
    private MOTable<MerstelMIBEntryRow, MOColumn,
        MOTableModel<MerstelMIBEntryRow>> merstelMIBEntry;
    private MOTableModel<MerstelMIBEntryRow> merstelMIBEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  /**
   * Constructs a MERSTEL-GR-MIB instance without actually creating its
   * <code>ManagedObject</code> instances. This has to be done in a
   * sub-class constructor or after construction by calling 
   * {@link #createMO(MOFactory moFactory)}. 
   */
  protected MerstelGrMib() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  /**
   * Constructs a MERSTEL-GR-MIB instance and actually creates its
   * <code>ManagedObject</code> instances using the supplied 
   * <code>MOFactory</code> (by calling
   * {@link #createMO(MOFactory moFactory)}).
   * @param moFactory
   *    the <code>MOFactory</code> to be used to create the
   *    managed objects for this module.
   */
  public MerstelGrMib(MOFactory moFactory) {
  	this();
    //--AgentGen BEGIN=_FACTORYCONSTRUCTOR::factoryWrapper
    //--AgentGen END
  	this.moFactory = moFactory;
    createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
//--AgentGen END
  }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

  /**
   * Create the ManagedObjects defined for this MIB module
   * using the specified {@link MOFactory}.
   * @param moFactory
   *    the <code>MOFactory</code> instance to use for object 
   *    creation.
   */
  protected void createMO(MOFactory moFactory) {
    addTCsToFactory(moFactory);
    createMerstelMIBEntry(moFactory);
  }



    @SuppressWarnings(value={"rawtypes"})
    public MOTable<MerstelMIBEntryRow,MOColumn,MOTableModel<MerstelMIBEntryRow>> getMerstelMIBEntry() {
        return merstelMIBEntry;
    }


    @SuppressWarnings(value={"unchecked"})
    private void createMerstelMIBEntry(MOFactory moFactory) {
        // Index definition
    merstelMIBEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidMerstelMIBType, 
                               SMIConstants.SYNTAX_OCTET_STRING, 0, 255),
      moFactory.createSubIndex(oidMerstelMIBIdentityevent, 
                               SMIConstants.SYNTAX_OCTET_STRING, 0, 255)
    };

    merstelMIBEntryIndex = 
      moFactory.createIndex(merstelMIBEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
    //--AgentGen BEGIN=merstelMIBEntry::isValidIndex
    //--AgentGen END
        return isValidIndex;
      }
    });

        // Columns
        MOColumn<?>[] merstelMIBEntryColumns = new MOColumn<?>[7];
        merstelMIBEntryColumns[idxMerstelMIBType] =
        moFactory.createColumn(colMerstelMIBType,
                               SMIConstants.SYNTAX_OCTET_STRING,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                               tcModuleSNMPv2Tc,
                               tcDefDisplayString);
        merstelMIBEntryColumns[idxMerstelMIBYear] =
        new MOMutableColumn<Integer32>(colMerstelMIBYear,
                          SMIConstants.SYNTAX_INTEGER,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null
    //--AgentGen BEGIN=merstelMIBYear::auxInit
    //--AgentGen END
          );
        ((MOMutableColumn<?>)merstelMIBEntryColumns[idxMerstelMIBYear]).
        addMOValueValidationListener(new MerstelMIBYearValidator());
        merstelMIBEntryColumns[idxMerstelMIBWeek] =
        new MOMutableColumn<Integer32>(colMerstelMIBWeek,
                          SMIConstants.SYNTAX_INTEGER,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null
    //--AgentGen BEGIN=merstelMIBWeek::auxInit
    //--AgentGen END
          );
        ((MOMutableColumn<?>)merstelMIBEntryColumns[idxMerstelMIBWeek]).
        addMOValueValidationListener(new MerstelMIBWeekValidator());
        merstelMIBEntryColumns[idxMerstelMIBDay] =
        new MOMutableColumn<Integer32>(colMerstelMIBDay,
                          SMIConstants.SYNTAX_INTEGER,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null
    //--AgentGen BEGIN=merstelMIBDay::auxInit
    //--AgentGen END
          );
        ((MOMutableColumn<?>)merstelMIBEntryColumns[idxMerstelMIBDay]).
        addMOValueValidationListener(new MerstelMIBDayValidator());
        merstelMIBEntryColumns[idxMerstelMIBHour] =
        new MOMutableColumn<Integer32>(colMerstelMIBHour,
                          SMIConstants.SYNTAX_INTEGER,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null
    //--AgentGen BEGIN=merstelMIBHour::auxInit
    //--AgentGen END
          );
        ((MOMutableColumn<?>)merstelMIBEntryColumns[idxMerstelMIBHour]).
        addMOValueValidationListener(new MerstelMIBHourValidator());
        merstelMIBEntryColumns[idxMerstelMIBMinute] =
        new MOMutableColumn<Integer32>(colMerstelMIBMinute,
                          SMIConstants.SYNTAX_INTEGER,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null
    //--AgentGen BEGIN=merstelMIBMinute::auxInit
    //--AgentGen END
          );
        ((MOMutableColumn<?>)merstelMIBEntryColumns[idxMerstelMIBMinute]).
        addMOValueValidationListener(new MerstelMIBMinuteValidator());
        merstelMIBEntryColumns[idxMerstelMIBIdentityevent] =
        moFactory.createColumn(colMerstelMIBIdentityevent,
                               SMIConstants.SYNTAX_OCTET_STRING,
                               moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                               tcModuleSNMPv2Tc,
                               tcDefDisplayString);
        // Table model
        merstelMIBEntryModel =
            moFactory.createTableModel(oidMerstelMIBEntry,
                                       merstelMIBEntryIndex,
                                       merstelMIBEntryColumns);
        ((MOMutableTableModel<MerstelMIBEntryRow>)merstelMIBEntryModel).setRowFactory(
            new MerstelMIBEntryRowFactory());
        merstelMIBEntry =
            moFactory.createTable(oidMerstelMIBEntry,
                                  merstelMIBEntryIndex,
                                  merstelMIBEntryColumns,
                                  merstelMIBEntryModel);
  }



  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
    // Scalar Objects
    server.register(this.merstelMIBEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
    // Scalar Objects
    server.unregister(this.merstelMIBEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  // Notifications
  public void merstelMIBNotification(NotificationOriginator notificationOriginator,
                                     OctetString context, VariableBinding[] vbs) {
    if (vbs.length < 2) {
      throw new IllegalArgumentException("Too few notification objects (merstelMIBNotification): "+
                                         vbs.length+"<2");
    }
    // merstelMIBType
    if (!(vbs[0].getOid().startsWith(oidTrapVarMerstelMIBType))) {
      throw new IllegalArgumentException("Variable 0 (merstelMIBType)) has wrong OID: "+vbs[0].getOid()+
                                         " does not start with "+oidTrapVarMerstelMIBType);
    }
    if (!merstelMIBEntryIndex.isValidIndex(merstelMIBEntry.getIndexPart(vbs[0].getOid()))) {
      throw new IllegalArgumentException("Illegal index for variable 0 (merstelMIBType)) specified: "+
                                         merstelMIBEntry.getIndexPart(vbs[0].getOid()));
    }
	{
		OctetString os = (OctetString)vbs[0].getVariable();
		if (!(((os.length() >= 0) && (os.length() <= 255)))) {
			throw new IllegalArgumentException("Illegal length of variable 0 (merstelMIBType)): " + os.length());
		}
    }

    // merstelMIBIdentityevent
    if (!(vbs[1].getOid().startsWith(oidTrapVarMerstelMIBIdentityevent))) {
      throw new IllegalArgumentException("Variable 1 (merstelMIBIdentityevent)) has wrong OID: "+vbs[1].getOid()+
                                         " does not start with "+oidTrapVarMerstelMIBIdentityevent);
    }
    if (!merstelMIBEntryIndex.isValidIndex(merstelMIBEntry.getIndexPart(vbs[1].getOid()))) {
      throw new IllegalArgumentException("Illegal index for variable 1 (merstelMIBIdentityevent)) specified: "+
                                         merstelMIBEntry.getIndexPart(vbs[1].getOid()));
    }
	{
		OctetString os = (OctetString)vbs[1].getVariable();
		if (!(((os.length() >= 0) && (os.length() <= 255)))) {
			throw new IllegalArgumentException("Illegal length of variable 1 (merstelMIBIdentityevent)): " + os.length());
		}
    }

    notificationOriginator.notify(context, oidMerstelMIBNotification, vbs);
  }
  
  


  // Scalars

  // Value Validators

  /**
   * The <code>MerstelMIBYearValidator</code> implements the value
   * validation for <code>MerstelMIBYear</code>.
   */
  static class MerstelMIBYearValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
    //--AgentGen BEGIN=merstelMIBYear::validate
    //--AgentGen END
    }
  }
  /**
   * The <code>MerstelMIBWeekValidator</code> implements the value
   * validation for <code>MerstelMIBWeek</code>.
   */
  static class MerstelMIBWeekValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
    //--AgentGen BEGIN=merstelMIBWeek::validate
    //--AgentGen END
    }
  }
  /**
   * The <code>MerstelMIBDayValidator</code> implements the value
   * validation for <code>MerstelMIBDay</code>.
   */
  static class MerstelMIBDayValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
    //--AgentGen BEGIN=merstelMIBDay::validate
    //--AgentGen END
    }
  }
  /**
   * The <code>MerstelMIBHourValidator</code> implements the value
   * validation for <code>MerstelMIBHour</code>.
   */
  static class MerstelMIBHourValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
    //--AgentGen BEGIN=merstelMIBHour::validate
    //--AgentGen END
    }
  }
  /**
   * The <code>MerstelMIBMinuteValidator</code> implements the value
   * validation for <code>MerstelMIBMinute</code>.
   */
  static class MerstelMIBMinuteValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
    //--AgentGen BEGIN=merstelMIBMinute::validate
    //--AgentGen END
    }
  }

  // Rows and Factories

  public class MerstelMIBEntryRow extends DefaultMOMutableRow2PC {

    //--AgentGen BEGIN=merstelMIBEntry::RowMembers
    //--AgentGen END

    public MerstelMIBEntryRow(OID index, Variable[] values) {
      super(index, values);
    //--AgentGen BEGIN=merstelMIBEntry::RowConstructor
    //--AgentGen END
    }
    
    public OctetString getMerstelMIBType() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBType
    //--AgentGen END
      return (OctetString) super.getValue(idxMerstelMIBType);
    }  
    
    public void setMerstelMIBType(OctetString newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBType
    //--AgentGen END
      super.setValue(idxMerstelMIBType, newColValue);
    }
    
    public Integer32 getMerstelMIBYear() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBYear
    //--AgentGen END
      return (Integer32) super.getValue(idxMerstelMIBYear);
    }  
    
    public void setMerstelMIBYear(Integer32 newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBYear
    //--AgentGen END
      super.setValue(idxMerstelMIBYear, newColValue);
    }
    
    public Integer32 getMerstelMIBWeek() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBWeek
    //--AgentGen END
      return (Integer32) super.getValue(idxMerstelMIBWeek);
    }  
    
    public void setMerstelMIBWeek(Integer32 newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBWeek
    //--AgentGen END
      super.setValue(idxMerstelMIBWeek, newColValue);
    }
    
    public Integer32 getMerstelMIBDay() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBDay
    //--AgentGen END
      return (Integer32) super.getValue(idxMerstelMIBDay);
    }  
    
    public void setMerstelMIBDay(Integer32 newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBDay
    //--AgentGen END
      super.setValue(idxMerstelMIBDay, newColValue);
    }
    
    public Integer32 getMerstelMIBHour() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBHour
    //--AgentGen END
      return (Integer32) super.getValue(idxMerstelMIBHour);
    }  
    
    public void setMerstelMIBHour(Integer32 newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBHour
    //--AgentGen END
      super.setValue(idxMerstelMIBHour, newColValue);
    }
    
    public Integer32 getMerstelMIBMinute() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBMinute
    //--AgentGen END
      return (Integer32) super.getValue(idxMerstelMIBMinute);
    }  
    
    public void setMerstelMIBMinute(Integer32 newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBMinute
    //--AgentGen END
      super.setValue(idxMerstelMIBMinute, newColValue);
    }
    
    public OctetString getMerstelMIBIdentityevent() {
    //--AgentGen BEGIN=merstelMIBEntry::getMerstelMIBIdentityevent
    //--AgentGen END
      return (OctetString) super.getValue(idxMerstelMIBIdentityevent);
    }  
    
    public void setMerstelMIBIdentityevent(OctetString newColValue) {
    //--AgentGen BEGIN=merstelMIBEntry::setMerstelMIBIdentityevent
    //--AgentGen END
      super.setValue(idxMerstelMIBIdentityevent, newColValue);
    }
    
    public Variable getValue(int column) {
    //--AgentGen BEGIN=merstelMIBEntry::RowGetValue
    //--AgentGen END
        switch(column) {
            case idxMerstelMIBType:
        	    return getMerstelMIBType();
            case idxMerstelMIBYear:
        	    return getMerstelMIBYear();
            case idxMerstelMIBWeek:
        	    return getMerstelMIBWeek();
            case idxMerstelMIBDay:
        	    return getMerstelMIBDay();
            case idxMerstelMIBHour:
        	    return getMerstelMIBHour();
            case idxMerstelMIBMinute:
        	    return getMerstelMIBMinute();
            case idxMerstelMIBIdentityevent:
        	    return getMerstelMIBIdentityevent();
            default:
                return super.getValue(column);
        }
    }
    
    public void setValue(int column, Variable value) {
    //--AgentGen BEGIN=merstelMIBEntry::RowSetValue
    //--AgentGen END
        switch(column) {
            case idxMerstelMIBType:
        	    setMerstelMIBType((OctetString)value);
        	    break;
            case idxMerstelMIBYear:
        	    setMerstelMIBYear((Integer32)value);
        	    break;
            case idxMerstelMIBWeek:
        	    setMerstelMIBWeek((Integer32)value);
        	    break;
            case idxMerstelMIBDay:
        	    setMerstelMIBDay((Integer32)value);
        	    break;
            case idxMerstelMIBHour:
        	    setMerstelMIBHour((Integer32)value);
        	    break;
            case idxMerstelMIBMinute:
        	    setMerstelMIBMinute((Integer32)value);
        	    break;
            case idxMerstelMIBIdentityevent:
        	    setMerstelMIBIdentityevent((OctetString)value);
        	    break;
            default:
                super.setValue(column, value);
            }
        }

    //--AgentGen BEGIN=merstelMIBEntry::Row
    //--AgentGen END
    }
  
    public class MerstelMIBEntryRowFactory implements MOTableRowFactory<MerstelMIBEntryRow>
    {
        public synchronized MerstelMIBEntryRow createRow(OID index, Variable[] values)
            throws UnsupportedOperationException
        {
            MerstelMIBEntryRow row = new MerstelMIBEntryRow(index, values);
    //--AgentGen BEGIN=merstelMIBEntry::createRow
    //--AgentGen END
            return row;
        }
    
        public synchronized void freeRow(MerstelMIBEntryRow row) {
    //--AgentGen BEGIN=merstelMIBEntry::freeRow
    //--AgentGen END
        }

    //--AgentGen BEGIN=merstelMIBEntry::RowFactory
    //--AgentGen END
    }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

  // Textual Definitions of MIB module MERSTEL-GR-MIB
  protected void addTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

  // Textual Definitions of other MIB modules
  public void addImportedTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


