/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.36
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua;

public class pjmedia_port_port_data {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected pjmedia_port_port_data(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(pjmedia_port_port_data obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      pjsuaJNI.delete_pjmedia_port_port_data(swigCPtr);
    }
    swigCPtr = 0;
  }

  public void setPdata(byte[] value) {
    pjsuaJNI.pjmedia_port_port_data_pdata_set(swigCPtr, this, value);
  }

  public byte[] getPdata() {
	return pjsuaJNI.pjmedia_port_port_data_pdata_get(swigCPtr, this);
}

  public void setLdata(int value) {
    pjsuaJNI.pjmedia_port_port_data_ldata_set(swigCPtr, this, value);
  }

  public int getLdata() {
    return pjsuaJNI.pjmedia_port_port_data_ldata_get(swigCPtr, this);
  }

  public pjmedia_port_port_data() {
    this(pjsuaJNI.new_pjmedia_port_port_data(), true);
  }

}
