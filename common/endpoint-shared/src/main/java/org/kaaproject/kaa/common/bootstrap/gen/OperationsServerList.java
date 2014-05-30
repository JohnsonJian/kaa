/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.kaaproject.kaa.common.bootstrap.gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OperationsServerList extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OperationsServerList\",\"namespace\":\"org.kaaproject.kaa.common.bootstrap.gen\",\"fields\":[{\"name\":\"operationsServerArray\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OperationsServer\",\"fields\":[{\"name\":\"DNSName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"Priority\",\"type\":\"int\"},{\"name\":\"PublicKey\",\"type\":\"bytes\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> operationsServerArray;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public OperationsServerList() {}

  /**
   * All-args constructor.
   */
  public OperationsServerList(java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> operationsServerArray) {
    this.operationsServerArray = operationsServerArray;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return operationsServerArray;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: operationsServerArray = (java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'operationsServerArray' field.
   */
  public java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> getOperationsServerArray() {
    return operationsServerArray;
  }

  /**
   * Sets the value of the 'operationsServerArray' field.
   * @param value the value to set.
   */
  public void setOperationsServerArray(java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> value) {
    this.operationsServerArray = value;
  }

  /** Creates a new OperationsServerList RecordBuilder */
  public static org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder newBuilder() {
    return new org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder();
  }
  
  /** Creates a new OperationsServerList RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder newBuilder(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder other) {
    return new org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder(other);
  }
  
  /** Creates a new OperationsServerList RecordBuilder by copying an existing OperationsServerList instance */
  public static org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder newBuilder(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList other) {
    return new org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder(other);
  }
  
  /**
   * RecordBuilder for OperationsServerList instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OperationsServerList>
    implements org.apache.avro.data.RecordBuilder<OperationsServerList> {

    private java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> operationsServerArray;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.operationsServerArray)) {
        this.operationsServerArray = data().deepCopy(fields()[0].schema(), other.operationsServerArray);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing OperationsServerList instance */
    private Builder(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList other) {
            super(org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.SCHEMA$);
      if (isValidValue(fields()[0], other.operationsServerArray)) {
        this.operationsServerArray = data().deepCopy(fields()[0].schema(), other.operationsServerArray);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'operationsServerArray' field */
    public java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> getOperationsServerArray() {
      return operationsServerArray;
    }
    
    /** Sets the value of the 'operationsServerArray' field */
    public org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder setOperationsServerArray(java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer> value) {
      validate(fields()[0], value);
      this.operationsServerArray = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'operationsServerArray' field has been set */
    public boolean hasOperationsServerArray() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'operationsServerArray' field */
    public org.kaaproject.kaa.common.bootstrap.gen.OperationsServerList.Builder clearOperationsServerArray() {
      operationsServerArray = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public OperationsServerList build() {
      try {
        OperationsServerList record = new OperationsServerList();
        record.operationsServerArray = fieldSetFlags()[0] ? this.operationsServerArray : (java.util.List<org.kaaproject.kaa.common.bootstrap.gen.OperationsServer>) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
