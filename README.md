---
author:
  - Tejasvi
date: 1970-01-01
title: Software Requirements Specification for the Standard Deviation
  Function
---

::: titlepage
![image](University_logo.jpg){width="100%"}

**SOEN 6011 (Software Engineering Processes)**

**Eternity - $\sigma$ (Standard Deviation function)**

_Tejasvi_

Student ID: 40292854
:::

# Introduction

This document presents a detailed Software Requirements Specification
(SRS) for the standard deviation function, following the ISO/IEC/IEEE
29148 Standard as per the course guidelines. The standard deviation
function is denoted as :
$$\sigma = \sqrt{(\frac{1}{N}\sum_{i=1}^{N}(x_i - \mu)^2)}$$

# Scope

The software to be designed will compute the standard deviation of a set
of real numbers (possibly array of ints/floats) in Java Programming
Language. The software will be used in scientific computing
applications.

# Definitions, Acronyms, and Abbreviations

- **SRS:** Software Requirements Specification

- **$\sigma$:** Standard deviation function

# Functional Requirements

## Input Requirements

- **FR1:** The function must accept a list of real numbers as input.

- **FR2:** The function must validate the input to ensure it is a list
  of real numbers.

## Processing Requirements

- **FR3:** The function must calculate the mean of the input numbers.

- **FR4:** The function must calculate the variance of the input
  numbers using the formula:
  $$\sigma^2 = \frac{1}{N}\sum_{i=1}^{N}(x_i - \mu)^2$$ where $N$ is
  the number of input numbers, $x_i$ is an input number, and $\mu$ is
  the mean of the input numbers.

## Output Requirements

- **FR5:** The function must calculate the standard deviation by
  taking the square root of the variance.

- **FR6:** The function must return the standard deviation as a real
  number.

# Non-Functional Requirements

- **NFR1:** The function must handle large lists of numbers
  efficiently.

- **NFR2:** The function must return accurate results up to a
  reasonable precision.

- **NFR3:** The function must provide error messages for invalid
  inputs.

# Assumptions and Dependencies

- **A1:** It is assumed that the input list is not empty.

- **A2:** It is assumed that the input numbers are real numbers.

# Algorithm for Standard Deviation Calculation

1.  Initialize a variable 'sum' to 0.

2.  For each number 'x' in the list of numbers:

    - Add 'x' to 'sum'.

3.  Calculate the mean 'mu' ($\mu$) by dividing 'sum' by the number of
    elements 'N' in the list (N is assumed to be greater than 0).

4.  Initialize a variable 'varianceSum' to 0.

5.  For each number 'x' in the list of numbers:

    - Subtract 'mu' from 'x' to get 'diff'.

    - Square 'diff' to get 'squaredDiff'.

    - Add 'squaredDiff' to 'varianceSum'.

6.  Calculate the variance by dividing 'varianceSum' by 'N'.

7.  Calculate the standard deviation 'sigma' by taking the square root
    of the variance.

# References

- ISO/IEC/IEEE 29148:2018 - Systems and software engineering -- Life
  cycle processes -- Requirements engineering.

- Standard deviation (2024) Wikipedia. Available at:
  <https://en.wikipedia.org/wiki/Standard_deviation> (Accessed: 04
  July 2024).
