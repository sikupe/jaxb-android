//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sun.xml.bind.v2.util;

import com.sun.xml.bind.Util;
import com.sun.xml.bind.v2.Messages;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class XmlFactory {
    private static final Logger LOGGER = Logger.getLogger(XmlFactory.class.getName());
    private static final String DISABLE_XML_SECURITY = "com.sun.xml.bind.disableXmlSecurity";
    public static final boolean DISABLE_SECURE_PROCESSING = Boolean.parseBoolean(Util.getSystemProperty("com.sun.xml.bind.disableXmlSecurity"));

    public XmlFactory() {
    }

    private static boolean xmlFeatureValue(boolean runtimeSetting) {
        return !DISABLE_SECURE_PROCESSING && !runtimeSetting;
    }

    public static SchemaFactory createSchemaFactory(String language, boolean disableSecureProcessing) throws IllegalStateException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(language);
            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "SchemaFactory instance: {0}", factory);
            }

            factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", xmlFeatureValue(disableSecureProcessing));
            return factory;
        } catch (SAXNotRecognizedException var3) {
            LOGGER.log(Level.SEVERE, (String) null, var3);
            throw new IllegalStateException(var3);
        } catch (SAXNotSupportedException var4) {
            LOGGER.log(Level.SEVERE, (String) null, var4);
            throw new IllegalStateException(var4);
        } catch (AbstractMethodError var5) {
            LOGGER.log(Level.SEVERE, (String) null, var5);
            throw new IllegalStateException(Messages.INVALID_JAXP_IMPLEMENTATION.format(new Object[0]), var5);
        }
    }

    public static SAXParserFactory createParserFactory(boolean disableSecureProcessing) throws IllegalStateException {
        try {
            SAXParserFactory factory = new com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl();
            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "SAXParserFactory instance: {0}", factory);
            }

            factory.setNamespaceAware(true);
            factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", xmlFeatureValue(disableSecureProcessing));
            return factory;
        } catch (ParserConfigurationException var2) {
            LOGGER.log(Level.SEVERE, (String) null, var2);
            throw new IllegalStateException(var2);
        } catch (SAXNotRecognizedException var3) {
            LOGGER.log(Level.SEVERE, (String) null, var3);
            throw new IllegalStateException(var3);
        } catch (SAXNotSupportedException var4) {
            LOGGER.log(Level.SEVERE, (String) null, var4);
            throw new IllegalStateException(var4);
        } catch (AbstractMethodError var5) {
            LOGGER.log(Level.SEVERE, (String) null, var5);
            throw new IllegalStateException(Messages.INVALID_JAXP_IMPLEMENTATION.format(new Object[0]), var5);
        }
    }

    public static XPathFactory createXPathFactory(boolean disableSecureProcessing) throws IllegalStateException {
        try {
            XPathFactory factory = XPathFactory.newInstance();
            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "XPathFactory instance: {0}", factory);
            }

            factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", xmlFeatureValue(disableSecureProcessing));
            return factory;
        } catch (XPathFactoryConfigurationException var2) {
            LOGGER.log(Level.SEVERE, (String) null, var2);
            throw new IllegalStateException(var2);
        } catch (AbstractMethodError var3) {
            LOGGER.log(Level.SEVERE, (String) null, var3);
            throw new IllegalStateException(Messages.INVALID_JAXP_IMPLEMENTATION.format(new Object[0]), var3);
        }
    }

    public static TransformerFactory createTransformerFactory(boolean disableSecureProcessing) throws IllegalStateException {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "TransformerFactory instance: {0}", factory);
            }

            factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", xmlFeatureValue(disableSecureProcessing));
            return factory;
        } catch (TransformerConfigurationException var2) {
            LOGGER.log(Level.SEVERE, (String) null, var2);
            throw new IllegalStateException(var2);
        } catch (AbstractMethodError var3) {
            LOGGER.log(Level.SEVERE, (String) null, var3);
            throw new IllegalStateException(Messages.INVALID_JAXP_IMPLEMENTATION.format(new Object[0]), var3);
        }
    }

    public static DocumentBuilderFactory createDocumentBuilderFactory(boolean disableSecureProcessing) throws IllegalStateException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.log(Level.FINE, "DocumentBuilderFactory instance: {0}", factory);
            }

            factory.setNamespaceAware(true);
            factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", xmlFeatureValue(disableSecureProcessing));
            return factory;
        } catch (ParserConfigurationException var2) {
            LOGGER.log(Level.SEVERE, (String) null, var2);
            throw new IllegalStateException(var2);
        } catch (AbstractMethodError var3) {
            LOGGER.log(Level.SEVERE, (String) null, var3);
            throw new IllegalStateException(Messages.INVALID_JAXP_IMPLEMENTATION.format(new Object[0]), var3);
        }
    }
}
