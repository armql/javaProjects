function eshtePrim(num) {
    // Shiko nese numri eshte me i vogel se 2 sepse ata asnje nuk jane prime
    if (num < 2) {
      return false;
    }
  
    // Nese numri eshte i barabart me 2 atehere eshte prim 
    // (Kushti 2)
    if (num === 2) {
      return true;
    }
  
    // Nese numri eshte i plotpjestueshem me 2 testo sepse ata numra e plotpjestueshem nuk jan prim perveq 2
    if (num % 2 === 0) {
      return false;
    }
  
    // nese asnjeri kusht nuk mundet me u permbush(perveq kushti 2) atehere dhe vetem atehere numri eshte prim
    return true;
}

console.log(eshtePrim(2));
console.log(eshtePrim(3));
console.log(eshtePrim(4));
console.log(eshtePrim(5));
console.log(eshtePrim(6));
console.log(eshtePrim(7));