🖥️ CPU Scheduling Simulator

🚀 Introduction

Welcome to the CPU Scheduling Simulator, a Java-based program with a sleek graphical user interface (GUI) designed to bring CPU scheduling algorithms to life! Dive into the world of operating systems and experience the dynamic behavior of various CPU scheduling techniques, including Non-Preemptive Priority Scheduling, Non-Preemptive Shortest Job First (SJF), Shortest-Remaining Time First (SRTF), and our custom AGAT Scheduling algorithm.

🌟 Overview

Scheduling is the heart of an operating system's functionality, determining the execution order of processes. This simulator demonstrates the impact of different CPU scheduling algorithms on resource utilization and system performance. It also addresses process starvation issues inherent in Non-Preemptive Priority Scheduling, Non-Preemptive SJF, and SRTF.

✨ Features

🏅 Non-Preemptive Priority Scheduling

Context switching with a focus on solving the starvation problem through any acceptable solution.

⏳ Non-Preemptive Shortest Job First (SJF)

Context switching with mechanisms to handle process starvation effectively.

🔄 Shortest-Remaining Time First (SRTF) Scheduling

Context switching with strategies to eliminate process starvation.

⚡ AGAT Scheduling

A unique algorithm combining Round Robin (RR) with factors like priority, arrival time, and remaining service time.
Each process has a distinct quantum.
Non-preemptive phase until 40% of the quantum, then switches to preemptive.
Replaces the current process with the one having the least AGAT factor after the non-preemptive phase.
Handles three scenarios for process management:
Process uses all quantum time but has remaining work: added to queue end, quantum time increased by 2.
Process preempted due to better AGAT factor: added to queue end, quantum time adjusted by remaining time.
Process completes its job: quantum time set to zero, removed from the queue.

📥 Program Input

Enter the following details to start the simulation:

Number of processes
Round Robin Time Quantum
Context switching time
For each process, provide:

Process Name
Process Color (for graphical representation)
Process Arrival Time
Process Burst Time
Process Priority Number

📤 Program Output

The simulator provides detailed outputs for each scheduling algorithm, including:

Execution order of processes
Waiting Time for each process
Turnaround Time for each process
Average Waiting Time
Average Turnaround Time
Quantum time updates history (AGAT Scheduling)
AGAT factor updates history (AGAT Scheduling)
