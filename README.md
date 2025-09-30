# Taxi-Dispatch-and-Booking-System
This repository contains a production-style Java implementation suitable for a call-centre environment: register customers and vehicles, book rides with fare calculation (including peak rates and luggage surcharge), and generate daily and monthly reports. The system is written for IntelliJ/Java (JDK 11+) and emphasises clean design, input validation, and testability.
## Project overview

Problem domain. Customers call a central operator to request one of three vehicle categories: ZoomerLite, ZoomerStandard, or ZoomerPro. Each category has capacity, distance limits, per-km pricing (different at peak hours), and extra charges (e.g. large-bag surcharge). The system records customers, vehicles and ride bookings, and produces operational reports for the business.

Designed for a call-centre operator workflow (simple menu/console UI suitable for screen-based terminals).

Strong separation of concerns: domain model, fare logic, persistence adapter (in-memory, easy to extend), and reporting.

Defensive input validation, clear domain rules and testable computation of fares — all characteristics required for a real dispatch/reporting component.

## Key features

Register new customers (unique customer ID + name).

Register new vehicles (unique registration, make, category, and odometer tracking).

Book rides with full metadata: rideID, customer ref, vehicle ref, date/time, start, destination, distance, passenger count, large-bag count.

Fare calculation rules:

ZoomerLite — 1 passenger only, max 10 km. $2/km normal, $4/km peak (7:00–9:00 & 17:00–19:00).

ZoomerStandard — 1–4 passengers, max 20 km. $2/km normal, $4/km peak per passenger.

ZoomerPro — 1–4 passengers, no distance cap. $3/km normal, $5/km peak per passenger. +$5 per large bag.

Daily ride report (list all rides booked that day).

Monthly summary per vehicle: number of rides, total kilometres driven, revenue generated.

Robust validation (capacity, distance limits, time format, passenger numbers).

Modular, well-documented codebase that uses inheritance, an abstract base vehicle class, at least one enum for category/time checks, and multiple cohesive classes.


           +----------------+
           |   Vehicle (A)  |<------------------------+
           +----------------+                         |
           | - regNumber    |                         |
           | - make         |                         |
           | - category     |                         |
           | - totalKms     |                         |
           +----------------+                         |
             ^         ^         ^                    |
             |         |         |                    |
+------------+   +-----+-----+ +--+------------+      |
| ZoomerLite |   | ZoomerStd | | ZoomerPro    |      |
+------------+   +-----------+ +--------------+      |
       |              |              |              |
       +--------------+--------------+--------------+
                      |
                 fare logic

