# Image Encryption Project

This project implements various image encryption and decryption techniques using C programming language. The implementation includes pixel manipulation, basic and advanced encryption algorithms.

## Files Description

- `encrypt.c` & `decrypt.c`: Main encryption and decryption implementation files
- `readingPixels.c`: Basic pixel reading functionality
- `withPixels.c`: Advanced pixel manipulation functions
- `q3.c`, `q4.c`, `q5.c`: Different encryption algorithm implementations
- Sample images for testing:
  - `elephant.bmp`
  - `pineapple.bmp`
  - `sunflower.bmp`
  - `tiger.bmp`

## Usage

Each C file can be compiled and run independently. For example:

```bash
gcc encrypt.c -o encrypt
./encrypt
```

The program works with BMP image files and implements various encryption techniques including:
- Basic pixel manipulation
- Advanced encryption algorithms
- Image scrambling techniques

## Requirements

- GCC compiler
- Input images should be in BMP format 