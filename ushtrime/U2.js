function rritShkronjaePareneFjali(input) {
    // Fjalia ndahet ne dy array te fjalive 
    const fjalia = input.split(" ");
  
    // Hyr ne te gjitha fjalit
    for (let i = 0; i < fjalia.length; i++) {
      // Dhe kushti ku kapitalizohet vetem njera fjali me substr identifikohet 1
      fjalia[i] = fjalia[i][0].toUpperCase() + fjalia[i].substr(1);
    }
  
    // Këtu e bashkon fjalinë prapë dhe e kthen te bashkuar 
    return fjalia.join(" ");
}

console.log(rritShkronjaePareneFjali('fifa world cup qatar'));
console.log(rritShkronjaePareneFjali('fifa corruption'));
console.log(rritShkronjaePareneFjali('ect'));

