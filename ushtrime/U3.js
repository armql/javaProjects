
function FjaliaMeEGjate(input) {
    // Procesi ndarjes se fjalise per kusht
    const fjalia = input.split(" ");
    
    // ketu vendoset fjalia me e gjate ne fjaline e pare me array
    let fjaliameEGjate = fjalia[0];
    
    // hapet for loop per fjali duke filluar prej fjalis se dyt te fjalis se ndare
    for (let i = 1; i < fjalia.length; i++) {
        //hapim nje kusht if nese fjalia tanishme eshte me e gjate se fjalia tanishme me e gjate
      if (fjalia[i].length > fjaliameEGjate.length) {
        // nese? po/jo atehere vendose ate fjali si fjalia me e gjate
        fjaliameEGjate = fjalia[i];
      }
    }
    
    // kthehet fjalia me e gjate
    return fjaliameEGjate;
}


console.log(FjaliaMeEGjate('Web Engineering'));
console.log(FjaliaMeEGjate('Computer Science'));
console.log(FjaliaMeEGjate('Algorithms and Data Structures'));
