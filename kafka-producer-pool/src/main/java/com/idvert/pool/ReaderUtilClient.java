package com.idvert.pool;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * Instantiates and uses a ReaderUtil. The GenericObjectPool supplied to the constructor will have
 * default configuration properties.
 */
public class ReaderUtilClient {

    public static void main(String[] args) {
        ReaderUtil readerUtil = new ReaderUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
        Reader reader = new StringReader("fommmmo");
        try {
            System.out.println(readerUtil.readToString(reader));
//            System.out.println(readerUtil.readToString(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}