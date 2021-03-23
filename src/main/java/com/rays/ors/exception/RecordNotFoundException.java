package com.rays.ors.exception;
/**
 * RecordNotFoundException thrown when a record not found occurred
 *
 * @author Prateek
 *
 */
public class RecordNotFoundException extends Exception{
	/**
     * @param msg
     *            error message
     */
	public RecordNotFoundException(String msg){
		super(msg);

	}
}
