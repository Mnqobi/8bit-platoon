/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eightbitplantoon.cic.bean;

import com.eightbitplantoon.cic.dao.CicRegistrationDAO;
import com.eightbitplantoon.cic.entities.CicEmail;
import com.eightbitplantoon.cic.inteface.CicRegistrationEngineRemote;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mnqobi Ngubane
 */
@Stateless
@Remote(CicRegistrationEngineRemote.class)
@LocalBean
public class CicRegistrationEngineBean implements CicRegistrationEngineRemote{
    @PersistenceContext(unitName = "com.eightbitplantoon.simplwa.pu")
    EntityManager em;
    
    /**
     *Receives the email information to be persisted
     * @param fromAddress
     * @param toAddress
     * @param emailBody
     * @param sentDate
     * @param recievedDate
     *  @return email info entered including primary key
     */
    @Override
    public CicEmail registerEmailCic(String fromAddress, String toAddress, String emailBody, Date sentDate, Date recievedDate) {
        CicRegistrationDAO cicRegistrationDAO = new CicRegistrationDAO(em);
        return cicRegistrationDAO.registerEmailCic(fromAddress, toAddress, emailBody, sentDate, recievedDate);
       
    }
    
    /**
     *Retrieves a list of email communications 
     * @return list of email communications 
     */
    @Override
    public List<CicEmail> retrieveEmailCicInfo () {
        CicRegistrationDAO cicRegistrationDAO = new CicRegistrationDAO(em);
        return cicRegistrationDAO.retrieveEmailCicInfo ();
        
    }

}
