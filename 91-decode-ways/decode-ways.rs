impl Solution 
{
    pub fn num_decodings(s: String) -> i32 
    {
        // [1] trivial cases
        if s.as_bytes()[0] == b'0' { return 0; }
        if s.len() == 1            { return 1; }
        
        // [2] number of decodings when adding one letter
        let mut d1 = 1;
        
        // [3] number of decodings when adding two letters
        let mut d2 = 1;

        // [4] iterate over the string and update decodings for the last two steps
        let mut n = 0;
        for w in s.as_bytes().windows(2)
        {
            n = 0;

            // [5] if current digit is not '0', we can add decodings from the step i-1
            if w[1] != b'0' { n += d1; }

            // [6] if two digits are in range from '10' to '26', we can add decodings from the step i-2
            if (w[0] == b'1') || (w[0] == b'2' && w[1]-b'0' <= 6) { n += d2; }

            // [7] update the number of decodings to be used on the next step
            d2 = d1;
            d1 = n;
        }
        
        return d1;
    }
}