/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.36
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua;

public class pjsua_acc_config {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected pjsua_acc_config(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(pjsua_acc_config obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      pjsuaJNI.delete_pjsua_acc_config(swigCPtr);
    }
    swigCPtr = 0;
  }

  public void setUser_data(byte[] value) {
    pjsuaJNI.pjsua_acc_config_user_data_set(swigCPtr, this, value);
  }

  public byte[] getUser_data() {
	return pjsuaJNI.pjsua_acc_config_user_data_get(swigCPtr, this);
}

  public void setPriority(int value) {
    pjsuaJNI.pjsua_acc_config_priority_set(swigCPtr, this, value);
  }

  public int getPriority() {
    return pjsuaJNI.pjsua_acc_config_priority_get(swigCPtr, this);
  }

  public void setId(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_id_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getId() {
    long cPtr = pjsuaJNI.pjsua_acc_config_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public void setReg_uri(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_reg_uri_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getReg_uri() {
    long cPtr = pjsuaJNI.pjsua_acc_config_reg_uri_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public void setPublish_enabled(int value) {
    pjsuaJNI.pjsua_acc_config_publish_enabled_set(swigCPtr, this, value);
  }

  public int getPublish_enabled() {
    return pjsuaJNI.pjsua_acc_config_publish_enabled_get(swigCPtr, this);
  }

  public void setAuth_pref(SWIGTYPE_p_pjsip_auth_clt_pref value) {
    pjsuaJNI.pjsua_acc_config_auth_pref_set(swigCPtr, this, SWIGTYPE_p_pjsip_auth_clt_pref.getCPtr(value));
  }

  public SWIGTYPE_p_pjsip_auth_clt_pref getAuth_pref() {
    return new SWIGTYPE_p_pjsip_auth_clt_pref(pjsuaJNI.pjsua_acc_config_auth_pref_get(swigCPtr, this), true);
  }

  public void setPidf_tuple_id(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_pidf_tuple_id_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getPidf_tuple_id() {
    long cPtr = pjsuaJNI.pjsua_acc_config_pidf_tuple_id_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public void setForce_contact(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_force_contact_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getForce_contact() {
    long cPtr = pjsuaJNI.pjsua_acc_config_force_contact_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public void setRequire_100rel(int value) {
    pjsuaJNI.pjsua_acc_config_require_100rel_set(swigCPtr, this, value);
  }

  public int getRequire_100rel() {
    return pjsuaJNI.pjsua_acc_config_require_100rel_get(swigCPtr, this);
  }

  public void setProxy_cnt(long value) {
    pjsuaJNI.pjsua_acc_config_proxy_cnt_set(swigCPtr, this, value);
  }

  public long getProxy_cnt() {
    return pjsuaJNI.pjsua_acc_config_proxy_cnt_get(swigCPtr, this);
  }

  public void setProxy(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_proxy_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getProxy() {
    long cPtr = pjsuaJNI.pjsua_acc_config_proxy_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public void setReg_timeout(long value) {
    pjsuaJNI.pjsua_acc_config_reg_timeout_set(swigCPtr, this, value);
  }

  public long getReg_timeout() {
    return pjsuaJNI.pjsua_acc_config_reg_timeout_get(swigCPtr, this);
  }

  public void setCred_count(long value) {
    pjsuaJNI.pjsua_acc_config_cred_count_set(swigCPtr, this, value);
  }

  public long getCred_count() {
    return pjsuaJNI.pjsua_acc_config_cred_count_get(swigCPtr, this);
  }

  public void setCred_info(pjsip_cred_info value) {
    pjsuaJNI.pjsua_acc_config_cred_info_set(swigCPtr, this, pjsip_cred_info.getCPtr(value), value);
  }

  public pjsip_cred_info getCred_info() {
    long cPtr = pjsuaJNI.pjsua_acc_config_cred_info_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pjsip_cred_info(cPtr, false);
  }

  public void setTransport_id(int value) {
    pjsuaJNI.pjsua_acc_config_transport_id_set(swigCPtr, this, value);
  }

  public int getTransport_id() {
    return pjsuaJNI.pjsua_acc_config_transport_id_get(swigCPtr, this);
  }

  public void setAllow_contact_rewrite(int value) {
    pjsuaJNI.pjsua_acc_config_allow_contact_rewrite_set(swigCPtr, this, value);
  }

  public int getAllow_contact_rewrite() {
    return pjsuaJNI.pjsua_acc_config_allow_contact_rewrite_get(swigCPtr, this);
  }

  public void setKa_interval(long value) {
    pjsuaJNI.pjsua_acc_config_ka_interval_set(swigCPtr, this, value);
  }

  public long getKa_interval() {
    return pjsuaJNI.pjsua_acc_config_ka_interval_get(swigCPtr, this);
  }

  public void setKa_data(pj_str_t value) {
    pjsuaJNI.pjsua_acc_config_ka_data_set(swigCPtr, this, pj_str_t.getCPtr(value), value);
  }

  public pj_str_t getKa_data() {
    long cPtr = pjsuaJNI.pjsua_acc_config_ka_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new pj_str_t(cPtr, false);
  }

  public pjsua_acc_config() {
    this(pjsuaJNI.new_pjsua_acc_config(), true);
  }

}
