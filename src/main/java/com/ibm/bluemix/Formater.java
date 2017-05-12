package com.ibm.bluemix;

class Formater {
  static Runnable nullSpace() {
    return new Runnable() {
      public void run() {
      }
    };
  }

  static Runnable space() {
    return new Runnable() {
      public void run() {
        System.out.println("");
      }
    };
  }
}
