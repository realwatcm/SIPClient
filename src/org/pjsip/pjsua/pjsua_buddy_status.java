/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.36
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua;

public enum pjsua_buddy_status {
  PJSUA_BUDDY_STATUS_UNKNOWN,
  PJSUA_BUDDY_STATUS_ONLINE,
  PJSUA_BUDDY_STATUS_OFFLINE;

  public final int swigValue() {
    return swigValue;
  }

  public static pjsua_buddy_status swigToEnum(int swigValue) {
    pjsua_buddy_status[] swigValues = pjsua_buddy_status.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (pjsua_buddy_status swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + pjsua_buddy_status.class + " with value " + swigValue);
  }

  private pjsua_buddy_status() {
    this.swigValue = SwigNext.next++;
  }

  private pjsua_buddy_status(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  private pjsua_buddy_status(pjsua_buddy_status swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

