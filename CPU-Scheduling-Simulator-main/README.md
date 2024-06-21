# CPU Scheduling Simulator

This project is a Java program with a graphical user interface (GUI) designed to simulate different CPU scheduling algorithms. The goal of this project is to provide a hands-on experience and visual representation of various CPU scheduling algorithms, including Non-Preemptive Priority Scheduling, Non-Preemptive Shortest Job First (SJF), Shortest-Remaining Time First (SRTF), and a custom algorithm called AGAT Scheduling.

## Overview

Scheduling is a fundamental function of operating systems, and CPU scheduling plays a vital role in determining which processes run when there are multiple runnable processes. This program aims to demonstrate the impact of different CPU scheduling algorithms on resource utilization and overall system performance. Additionally, it addresses the issue of process starvation for Non-Preemptive Priority Scheduling, Non-Preemptive SJF, and SRTF.

## Features

The CPU Scheduling Simulator provides the following features:

1. Non-Preemptive Priority Scheduling with context switching:
   - Ensures the solution to the starvation problem (any acceptable solution).
2. Non-Preemptive Shortest Job First (SJF) with context switching:
   - Solves the starvation problem (any acceptable solution).
3. Shortest-Remaining Time First (SRTF) Scheduling with context switching:
   - Solves the starvation problem (any acceptable solution).
4. AGAT Scheduling:
   - Implements a custom algorithm that combines Round Robin (RR) CPU scheduling with a unique factor based on priority, arrival time, and remaining service time.
   - Each process in AGAT scheduling has a different quantum.
   - Implements a non-preemptive phase for each process until reaching approximately 40% of the quantum, after which it becomes preemptive.
   - Provides the ability to replace a process with the best (least) AGAT factor, if available, after the non-preemptive phase ends.
   - Handles three scenarios for a running process:
     - If the process used all its quantum time and still has remaining work, it is added to the end of the queue, and its quantum time is increased by 2. The next process is picked from the queue.
     - If the process didn't use all its quantum time because it was removed in favor of a process with a better AGAT factor, it is added to the end of the queue, and its quantum time is increased by the remaining quantum time for it.
     - If the process finished its job, its quantum time is set to zero, it is removed from the ready queue, and added to the dead list.

## Program Input

The program expects the following input:

- Number of processes
- Round Robin Time Quantum
- Context switching

For each process, the user needs to provide the following parameters:

- Process Name
- Process Color (Graphical Representation)
- Process Arrival Time
- Process Burst Time
- Process Priority Number

## Program Output

For each scheduler, the program provides the following output:

- Processes execution order
- Waiting Time for each process
- Turnaround Time for each process
- Average Waiting Time
- Average Turnaround Time
- History of all quantum time updates for each process (AGAT Scheduling)
- History of all AGAT factor updates for each process (AGAT Scheduling)

## Getting Started

To run the CPU Scheduling Simulator, follow these steps:

