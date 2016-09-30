package com.ejb.service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class StatelessEJB
 */
@Stateless
public class StatelessEJB implements StatelessEJBRemote, StatelessEJBLocal {

    /**
	 * 
	 */
	private static final long serialVersionUID = 99987656781L;

	/**
     * Default constructor. 
     */
    public StatelessEJB() {
        // TODO Auto-generated constructor stub
    	
    	System.out.println("EJB Initializeds : Default constructor");
    }

	public void getStatlessEJBMethod() {
		// TODO Auto-generated method stub
		System.out.println("EJB Initializeds : Method called");
	}

}
