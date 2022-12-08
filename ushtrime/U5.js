function numeroZanoret(input) {
    // Hapim nje kounter(numerues) prej 0;
    let count = 0;
  
    // Bejme loop per qdo karakter ne fjali
    for (const char of input) {
      // Check if the character is a vowel (lowercase or uppercase)
      if (char === "a" || char === "e" || char === "ë" || char === "i" || char === "o" ||
          char === "u" || char === "y" ||
          char === "A" || char === "E" || char === "Ë" || char === "I" || char === "O" ||
          char === "U" || char === "Y") {
        // Shto ne kounter nese ne fjali ka nje zanore
        count++;
      }
    }
  
    // kthe se sa zanore kemi prej kounterit
    return count;
}

console.log(numeroZanoret("Arlind"));
console.log(numeroZanoret("Maliqi"));
console.log(numeroZanoret("është"));
console.log(numeroZanoret("Është"));
console.log(numeroZanoret("Zgj"));