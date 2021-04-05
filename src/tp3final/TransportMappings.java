package tp3final; 

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import org.snmp4j.SNMP4JSettings;
import org.snmp4j.TransportMapping;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.log.LogFactory;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.TlsAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.transport.TLSTM;

public class TransportMappings {

     private static final LogAdapter logger = LogFactory.getLogger(TransportMappings.class);
    public static final String TRANSPORT_MAPPINGS =
      "org.snmp4j.transportMappings";
  private static final String TRANSPORT_MAPPINGS_DEFAULT =
      "transports.properties";

  private static TransportMappings instance = null;
  private Hashtable<String, Class<? extends TransportMapping>> transportMappings = null;

    public TransportMappings() {
    }

    public static TransportMappings getInstance() {
        if (instance == null) {
      instance = new TransportMappings();
    }
    return instance;
    }

    public TransportMapping<? extends Address> createTransportMapping(Address transportAddress) {
    if (transportMappings == null) {
      registerTransportMappings();
    }
    Class<? extends TransportMapping> c =
            transportMappings.get(transportAddress.getClass().getName());
    if (c == null) {
      return null;
    }
    Class[] params = new Class[1];
    params[0] = transportAddress.getClass();
    Constructor<? extends TransportMapping> constructor;
    try {
      try {
        constructor = c.getConstructor(params);
        return constructor.newInstance(transportAddress);
      }
      catch (NoSuchMethodException nsme) {
        Constructor<? extends TransportMapping>[] cs = (Constructor<? extends TransportMapping>[]) c.getConstructors();
        for (Constructor<? extends TransportMapping> cons : cs) {
          Class[] params2 = cons.getParameterTypes();
          if ((params2.length == 1) && (params2[0].isAssignableFrom(params[0]))) {
            return cons.newInstance(transportAddress);
          }
        }
        logger.error("NoSuchMethodException while instantiating "+c.getName(), nsme);
        return null;
      }
    }
    catch (InvocationTargetException ite) {
      if (logger.isDebugEnabled()) {
        ite.printStackTrace();
      }
      logger.error(ite);
      throw new RuntimeException(ite.getTargetException());
    }
    catch (Exception ex) {
      if (logger.isDebugEnabled()) {
        ex.printStackTrace();
      }
      logger.error(ex);
      return null;
    }
  }

    @SuppressWarnings("unchecked")
  protected synchronized void registerTransportMappings() {
    if (SNMP4JSettings.isExtensibilityEnabled()) {
      String transports =
          System.getProperty(TRANSPORT_MAPPINGS, TRANSPORT_MAPPINGS_DEFAULT);
      InputStream is = TransportMappings.class.getResourceAsStream(transports);
      if (is == null) {
        throw new InternalError("Could not read '" + transports +
                                "' from classpath!");
      }
      Properties props = new Properties();
      try {
        props.load(is);
        Hashtable<String, Class<? extends TransportMapping>> t =
            new Hashtable<String, Class<? extends TransportMapping>>(props.size());
        for (Enumeration en = props.propertyNames(); en.hasMoreElements(); ) {
          String addressClassName = en.nextElement().toString();
          String className = props.getProperty(addressClassName);
          try {
            Class<? extends TransportMapping> c = (Class<? extends TransportMapping>)Class.forName(className);
            t.put(addressClassName, c);
          }
          catch (ClassNotFoundException cnfe) {
            logger.error(cnfe);
          }
        }
        // atomic syntax registration
        transportMappings = t;
      }
      catch (IOException iox) {
        String txt = "Could not read '" + transports + "': " +
            iox.getMessage();
        logger.error(txt);
        throw new InternalError(txt);
      }
      finally {
        try {
          is.close();
        }
        catch (IOException ex) {
          logger.warn(ex);
        }
      }
    }
    else {
      Hashtable<String, Class<? extends TransportMapping>> t =
          new Hashtable<String, Class<? extends TransportMapping>>(2);
      t.put(UdpAddress.class.getName(), DefaultUdpTransportMapping.class);
      t.put(TcpAddress.class.getName(), DefaultTcpTransportMapping.class);
      t.put(TlsAddress.class.getName(), TLSTM.class);
      transportMappings = t;
    }
  }
  
  public void bleff(){
      //bluff
  }
}
