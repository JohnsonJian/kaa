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
package org.kaaproject.kaa.common.endpoint.gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Notification extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Notification\",\"namespace\":\"org.kaaproject.kaa.common.endpoint.gen\",\"fields\":[{\"name\":\"topicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"NotificationType\",\"symbols\":[\"SYSTEM\",\"CUSTOM\"]}},{\"name\":\"uid\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"seqNumber\",\"type\":[\"int\",\"null\"]},{\"name\":\"body\",\"type\":\"bytes\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.lang.String topicId;
   private org.kaaproject.kaa.common.endpoint.gen.NotificationType type;
   private java.lang.String uid;
   private java.lang.Integer seqNumber;
   private java.nio.ByteBuffer body;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public Notification() {}

  /**
   * All-args constructor.
   */
  public Notification(java.lang.String topicId, org.kaaproject.kaa.common.endpoint.gen.NotificationType type, java.lang.String uid, java.lang.Integer seqNumber, java.nio.ByteBuffer body) {
    this.topicId = topicId;
    this.type = type;
    this.uid = uid;
    this.seqNumber = seqNumber;
    this.body = body;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return topicId;
    case 1: return type;
    case 2: return uid;
    case 3: return seqNumber;
    case 4: return body;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: topicId = (java.lang.String)value$; break;
    case 1: type = (org.kaaproject.kaa.common.endpoint.gen.NotificationType)value$; break;
    case 2: uid = (java.lang.String)value$; break;
    case 3: seqNumber = (java.lang.Integer)value$; break;
    case 4: body = (java.nio.ByteBuffer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'topicId' field.
   */
  public java.lang.String getTopicId() {
    return topicId;
  }

  /**
   * Sets the value of the 'topicId' field.
   * @param value the value to set.
   */
  public void setTopicId(java.lang.String value) {
    this.topicId = value;
  }

  /**
   * Gets the value of the 'type' field.
   */
  public org.kaaproject.kaa.common.endpoint.gen.NotificationType getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(org.kaaproject.kaa.common.endpoint.gen.NotificationType value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'uid' field.
   */
  public java.lang.String getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * @param value the value to set.
   */
  public void setUid(java.lang.String value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'seqNumber' field.
   */
  public java.lang.Integer getSeqNumber() {
    return seqNumber;
  }

  /**
   * Sets the value of the 'seqNumber' field.
   * @param value the value to set.
   */
  public void setSeqNumber(java.lang.Integer value) {
    this.seqNumber = value;
  }

  /**
   * Gets the value of the 'body' field.
   */
  public java.nio.ByteBuffer getBody() {
    return body;
  }

  /**
   * Sets the value of the 'body' field.
   * @param value the value to set.
   */
  public void setBody(java.nio.ByteBuffer value) {
    this.body = value;
  }

  /** Creates a new Notification RecordBuilder */
  public static org.kaaproject.kaa.common.endpoint.gen.Notification.Builder newBuilder() {
    return new org.kaaproject.kaa.common.endpoint.gen.Notification.Builder();
  }
  
  /** Creates a new Notification RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.common.endpoint.gen.Notification.Builder newBuilder(org.kaaproject.kaa.common.endpoint.gen.Notification.Builder other) {
    return new org.kaaproject.kaa.common.endpoint.gen.Notification.Builder(other);
  }
  
  /** Creates a new Notification RecordBuilder by copying an existing Notification instance */
  public static org.kaaproject.kaa.common.endpoint.gen.Notification.Builder newBuilder(org.kaaproject.kaa.common.endpoint.gen.Notification other) {
    return new org.kaaproject.kaa.common.endpoint.gen.Notification.Builder(other);
  }
  
  /**
   * RecordBuilder for Notification instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Notification>
    implements org.apache.avro.data.RecordBuilder<Notification> {

    private java.lang.String topicId;
    private org.kaaproject.kaa.common.endpoint.gen.NotificationType type;
    private java.lang.String uid;
    private java.lang.Integer seqNumber;
    private java.nio.ByteBuffer body;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.common.endpoint.gen.Notification.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.common.endpoint.gen.Notification.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.topicId)) {
        this.topicId = data().deepCopy(fields()[0].schema(), other.topicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uid)) {
        this.uid = data().deepCopy(fields()[2].schema(), other.uid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.seqNumber)) {
        this.seqNumber = data().deepCopy(fields()[3].schema(), other.seqNumber);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.body)) {
        this.body = data().deepCopy(fields()[4].schema(), other.body);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Notification instance */
    private Builder(org.kaaproject.kaa.common.endpoint.gen.Notification other) {
            super(org.kaaproject.kaa.common.endpoint.gen.Notification.SCHEMA$);
      if (isValidValue(fields()[0], other.topicId)) {
        this.topicId = data().deepCopy(fields()[0].schema(), other.topicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uid)) {
        this.uid = data().deepCopy(fields()[2].schema(), other.uid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.seqNumber)) {
        this.seqNumber = data().deepCopy(fields()[3].schema(), other.seqNumber);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.body)) {
        this.body = data().deepCopy(fields()[4].schema(), other.body);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'topicId' field */
    public java.lang.String getTopicId() {
      return topicId;
    }
    
    /** Sets the value of the 'topicId' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder setTopicId(java.lang.String value) {
      validate(fields()[0], value);
      this.topicId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'topicId' field has been set */
    public boolean hasTopicId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'topicId' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder clearTopicId() {
      topicId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'type' field */
    public org.kaaproject.kaa.common.endpoint.gen.NotificationType getType() {
      return type;
    }
    
    /** Sets the value of the 'type' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder setType(org.kaaproject.kaa.common.endpoint.gen.NotificationType value) {
      validate(fields()[1], value);
      this.type = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'type' field has been set */
    public boolean hasType() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'type' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder clearType() {
      type = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'uid' field */
    public java.lang.String getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder setUid(java.lang.String value) {
      validate(fields()[2], value);
      this.uid = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'uid' field has been set */
    public boolean hasUid() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'uid' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder clearUid() {
      uid = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'seqNumber' field */
    public java.lang.Integer getSeqNumber() {
      return seqNumber;
    }
    
    /** Sets the value of the 'seqNumber' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder setSeqNumber(java.lang.Integer value) {
      validate(fields()[3], value);
      this.seqNumber = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'seqNumber' field has been set */
    public boolean hasSeqNumber() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'seqNumber' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder clearSeqNumber() {
      seqNumber = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'body' field */
    public java.nio.ByteBuffer getBody() {
      return body;
    }
    
    /** Sets the value of the 'body' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder setBody(java.nio.ByteBuffer value) {
      validate(fields()[4], value);
      this.body = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'body' field has been set */
    public boolean hasBody() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'body' field */
    public org.kaaproject.kaa.common.endpoint.gen.Notification.Builder clearBody() {
      body = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public Notification build() {
      try {
        Notification record = new Notification();
        record.topicId = fieldSetFlags()[0] ? this.topicId : (java.lang.String) defaultValue(fields()[0]);
        record.type = fieldSetFlags()[1] ? this.type : (org.kaaproject.kaa.common.endpoint.gen.NotificationType) defaultValue(fields()[1]);
        record.uid = fieldSetFlags()[2] ? this.uid : (java.lang.String) defaultValue(fields()[2]);
        record.seqNumber = fieldSetFlags()[3] ? this.seqNumber : (java.lang.Integer) defaultValue(fields()[3]);
        record.body = fieldSetFlags()[4] ? this.body : (java.nio.ByteBuffer) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
