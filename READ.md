Test Project for Casumo

Stack: Java+RestAssured+TestNG

- Problem which I found:
1) 500 Internal Server Error -- every 5th request (solved by RetryAnalyzer)
2) Uppercase Vowels are not removed
3) Different result on web and API for request which contains "#"
   for example /in#put:
   1) web shows "n"
   2) API returns "/n#pt"
4) Need to clarify available Special Symbols, because some of them can cause infinity request "{"
5) System doesn't support vowel symbols from another languages (Cyrillic and Diacritic)
6) Spaces trimming (all deleted if first/last, and left only 1 if in the middle)
7) Upper input limit is 8000 characters, 8001 thrown NoHttpResponseException

- Statistics:
1) Main Tests: 
   3 passed, 1 failed
2) Boundary Values Tests:
   12 passed, 7 failed
3) Negative Boundary Tests:
   2 passed, 0 failed
4) Spaces Tests: 
   1 passed, 6 failed
5) Total
   18 passed, 19 failed