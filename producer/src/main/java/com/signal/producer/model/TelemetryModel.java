package com.signal.producer.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TelemetryModel implements Serializable {

    private UUID uuid;

    private Long signalChanel;

    private UUID sensorId;

    private String signalPayload;


}
