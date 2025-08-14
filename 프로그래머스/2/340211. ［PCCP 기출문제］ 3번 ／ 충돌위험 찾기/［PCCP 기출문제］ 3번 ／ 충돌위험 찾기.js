function solution(points, routes) {
    let answer = 0;
        
    let current = [];
    
    for (let i = 0; i < routes.length; i++) {
        current.push([...points[routes[i][0]-1]]);
    }
    
    let flag = [];
    for (let i = 0; i < routes.length; i++) {
        flag[i] = [];
        for (let j = 0; j < routes[i].length; j++) {
            flag[i][j] = false;
        }
    }
    
    let count = 0;
    
    while (current.length > 0) {
        // 현재 위치에서 충돌이 있는지 체크
        // console.log(current);
        // console.log(flag);
        let check = [];
        count++;
        for (let i = 0; i < current.length-1; i++) {
            if (check[i]) continue;
            if (flag[i][flag[i].length-1]) continue;
            for (let j = i+1; j < current.length; j++) {
                if (flag[j][flag[j].length-1]) continue;
                if (current[i][0] === current[j][0] && current[i][1] === current[j][1]) {
                    check[i] = true;
                    check[j] = true;
                }
            }
            if (check[i]) {
            
                // console.log(i);
                // console.log(check);
                
                answer++
            }
        }
        
        
        // 다 이동했는지 체크
        let finish = true;
        let temp = [];
        let temp2 = [];
        for (let i = 0; i < flag.length; i++) {
            if (!flag[i][flag[i].length-1]) {
                finish = false;

                break;
            }
        }
        // current = temp;
        // flag = temp2;
        if (finish) break;
        
        // 루트를 확인하며 이동
        for (let i = 0; i < flag.length; i++) {
            for (let j = 0; j < flag[i].length; j++) {
                if (!flag[i][j]) {
                    let target = points[routes[i][j]-1];
                    if (current[i][0] < target[0]) current[i][0]++;
                    else if (current[i][0] > target[0]) current[i][0]--;
                    else if (current[i][1] < target[1]) current[i][1]++;
                    else if (current[i][1] > target[1]) current[i][1]--;
                    else {
                        flag[i][j] = true;
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    return answer;
}