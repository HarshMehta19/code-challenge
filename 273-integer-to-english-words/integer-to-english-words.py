class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0: return "Zero"

        ones = {
            1: "One",
            2: "Two",
            3: "Three",
            4: "Four",
            5: "Five",
            6: "Six",
            7: "Seven",
            8: "Eight",
            9: "Nine",
            10: "Ten",
            11: "Eleven",
            12: "Twelve",
            13: "Thirteen",
            14: "Fourteen",
            15: "Fifteen",
            16: "Sixteen",
            17: "Seventeen",
            18: "Eighteen",
            19: "Nineteen"
        }

        tens = {
            20: "Twenty",
            30: "Thirty",
            40: "Forty",
            50: "Fifty",
            60: "Sixty",
            70: "Seventy",
            80: "Eighty",
            90: "Ninety"
        }


        def get_string(n):
            res = []
            hundred  = n // 100
            if hundred:
                res.append(ones[hundred]+" Hundred")

            last_2 = n % 100
            if last_2 >= 20:
                ten, one = last_2 // 10, last_2 % 10
                res.append(tens[ten * 10])
                if one:
                    res.append(ones[one])
            elif last_2:
                res.append(ones[last_2])
            return " ".join(res)
        i = 0
        res = []
        bigString = ["", " Thousand", " Million", " Billion"]

        while num:
            digits = num % 1000

            s = get_string(digits)
            if s:
                res.append(s + bigString[i])
            num = num // 1000
            i+=1
        res.reverse()
        return " ".join(res)