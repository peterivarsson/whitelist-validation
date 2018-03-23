# Whitelist validation

## This is a small lib with bean validation annotations

```
@Ascii
Check string only has Ascii characters

@AsciiDigit
Check string only has Ascii characters and digits

@Digit
Check string is only digits

@Latin
Check string only has Latin characters and space

@LatinDigit
Check string only has Latin characters, space and digits

@LatinWhitespace
Check string only has Latin characters and whitespace

@LatinWhitespaceDigit
Check string only has Latin characters, whitespace and digits

@Unicode
Check string only has Unicode characters and whitespace

@UnicodeDigit
Check string only has Unicode characters, whitespace and digits
```

For security reason every client input should be validated on the server side (Backend).
Since you can not trust the validation on client side which be manipulated by malicious code.

This is implemented as an white list (Check that only allowed characters is in the input)
