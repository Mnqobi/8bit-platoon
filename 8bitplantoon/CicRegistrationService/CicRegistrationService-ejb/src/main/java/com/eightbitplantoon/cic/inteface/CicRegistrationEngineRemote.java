/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eightbitplantoon.cic.inteface;

import com.eightbitplantoon.cic.bean.CicRegistrationEngineBean;
import com.eightbitplantoon.cic.entities.CicEmail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mnqobi Ngubane
 */

public interface CicRegistrationEngineRemote {
    public static final String JNDI_LOCATION = "CicRegistrationService-ear" + "/" + "CicRegistrationService-ejb" + "/" + CicRegistrationEngineBean.class.getSimpleName() + "!" + CicRegistrationEngineRemote.class.getName();
    /**
     *Receives the email information to be persisted
     * @param fromAddress
     * @param toAddress
     * @param emailBody
     * @param sentDate
     * @param recievedDate
     *  @return email info entered including primary key
     */
    public CicEmail registerEmailCic(String fromAddress, String toAddress, String emailBody, Date sentDate, Date recievedDate);
    
    /**
     *Retrieves a list of email communications 
     * @return list of email communications 
     */
    public List<CicEmail> retrieveEmailCicInfo ();

}
