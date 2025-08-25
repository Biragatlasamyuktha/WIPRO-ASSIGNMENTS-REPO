package com.example.hari;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

//Patient class
class Patient {
	private final String name;
	private final int severity;
	private final long arrivalOrder; // timestamp or counter for arrival
	public Patient(String name, int severity, long arrivalOrder) {
		this.name = name;
		this.severity = severity;
		this.arrivalOrder = arrivalOrder;
	}

	public int getSeverity() {
		return severity;
	}

	public long getArrivalOrder() {
		return arrivalOrder;
	}

	public String toString() {
		return "Patient{name='" + name + "', severity=" + severity + ", arrival=" + arrivalOrder + '}';
	}
   }


public class EmergencyPatientTracker {
	private static final int MAX_CAPACITY = 5;
    private final AtomicLong counter = new AtomicLong(0); // ensures unique order
    private final PriorityQueue<Patient> queue;

    public EmergencyPatientTracker() {
        queue = new PriorityQueue<>(Comparator
            .comparingInt(Patient::getSeverity)                     // lower severity first
            .thenComparingLong(Patient::getArrivalOrder));          // older arrival first
    }

    public boolean addPatient(String name, int severity) {
        if (queue.size() >= MAX_CAPACITY) {
            System.out.println("Queue is full! Cannot add patient: " + name);
            return false;
        }
        Patient patient = new Patient(name, severity, counter.getAndIncrement());
        queue.offer(patient);
        System.out.println("Added: " + patient);
        return true;
    }

    public Patient treatPatient() {
        Patient patient = queue.poll();
        if (patient != null) {
            System.out.println("Treated: " + patient);
        } else {
            System.out.println("No patients to treat.");
        }
        return patient;
    }

    // Demo
    public static void main(String[] args) {
        EmergencyPatientTracker tracker = new EmergencyPatientTracker();

        tracker.addPatient("Aravind", 3);
        tracker.addPatient("Baby", 2);
        tracker.addPatient("Ram", 2);
        tracker.addPatient("Sita", 1);
        tracker.addPatient("Raju", 4);
        tracker.addPatient("Rani", 5); // Should be rejected

        tracker.treatPatient(); 
        tracker.treatPatient(); 
        tracker.treatPatient(); 
    }

}
