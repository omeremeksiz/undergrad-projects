# STM32 Distance Detector Project

An embedded system implementation of a distance detection system using the STM32L073RZ microcontroller.

## Project Structure

- `Core/`: Contains the main application code
  - `Inc/`: Header files
    - `main.h`: Main program header
    - `stm32l0xx_hal_conf.h`: HAL configuration
    - `stm32l0xx_it.h`: Interrupt handlers
  - `Src/`: Source files
    - `main.c`: Main program implementation
    - `stm32l0xx_hal_msp.c`: HAL MSP initialization
    - `stm32l0xx_it.c`: Interrupt handlers implementation
  - `Startup/`: Microcontroller startup code

## Features

- Real-time distance measurement
- STM32L073RZ microcontroller implementation
- HAL (Hardware Abstraction Layer) based development
- Interrupt-driven operation
- Configurable measurement parameters

## Hardware Requirements

- STM32L073RZ Nucleo board
- Distance sensor (details in documentation)
- Supporting electronic components (as per schematic)

## Development Environment

- STM32CubeIDE
- STM32CubeMX for initial project configuration
- STM32L0 HAL drivers

## Building and Flashing

1. Open the project in STM32CubeIDE
2. Build the project using the hammer icon or Project -> Build Project
3. Connect your STM32L073RZ board
4. Flash the program using the Run button or Run -> Debug

## Documentation

For detailed implementation information and circuit diagrams, refer to the project report:
- `Omer_Sabri_Emeksiz_150721841_Report.pdf` 