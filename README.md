# Taxi-Dispatch-and-Booking-System
This repository contains a production-style Java implementation suitable for a call-centre environment: register customers and vehicles, book rides with fare calculation (including peak rates and luggage surcharge), and generate daily and monthly reports. The system is written for IntelliJ/Java (JDK 11+) and emphasises clean design, input validation, and testability.
## Project overview

Problem domain. Customers call a central operator to request one of three vehicle categories: ZoomerLite, ZoomerStandard, or ZoomerPro. Each category has capacity, distance limits, per-km pricing (different at peak hours), and extra charges (e.g. large-bag surcharge). The system records customers, vehicles and ride bookings, and produces operational reports for the business.

Why this is production-relevant.

Designed for a call-centre operator workflow (simple menu/console UI suitable for screen-based terminals).

Strong separation of concerns: domain model, fare logic, persistence adapter (in-memory, easy to extend), and reporting.

Defensive input validation, clear domain rules and testable computation of fares — all characteristics required for a real dispatch/reporting component.
