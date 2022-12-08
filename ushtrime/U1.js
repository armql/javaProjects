function eshtePalindrome(input) {
    // Fillimisht e ndajm fjalinë dhe e shikojm nëse është e njejt kur kthehet ne reverse dhe nese po ate here
    // plotësohet kushti ;true nese jo atehere nuk plotesohet kushti ;false
    if (input === input.split('').reverse().join('')) {
      return true;
    } else {
      return false;
    }
  }

console.log(eshtePalindrome('arra'));
console.log(eshtePalindrome('radar'));
console.log(eshtePalindrome('lol'));
console.log(eshtePalindrome('nuk jam palindrome'));
console.log(eshtePalindrome('spray'));