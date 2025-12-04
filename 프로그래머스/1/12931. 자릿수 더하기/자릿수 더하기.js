function solution(n)
{
    var answer = 0;
    
    for(var i of String(n)) {
        answer += parseInt(i)
    }

    return answer;
}