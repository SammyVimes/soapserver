package com.study.eltech;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Семён on 26.12.2014.
 */
@WebService()
public class Server {

    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSSS");

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from + " current date: " + df.format(new Date());
        System.out.println(result + " " + Thread.currentThread());
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new Server ();
        String address = "http://localhost:9000/SoapServer";
        Endpoint.publish(address, implementor);
    }

}