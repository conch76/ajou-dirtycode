# ajou-dirtycode
Dirty code for refactoring

<br>

## Code Analysis

### DirtySample class 

-  `item[] items` 를 변수로 가짐
- `updateQuality()` 메소드를 가짐 

### item class

- `String name`
- `int sellIn`
- `int quality`
- `toString()`

### updateQuality() 분석 (rough ver.)

  - `items` 리스트의 처음부터 끝까지 모든 `item` 에 대해
    - `item` 의 이름이 `Aged Brie` , `Backstage passes to a TAFKAL80ETC concert` 이 아니고
        - `item` 의 `quality` 가 0보다 크고,
            - 이름이 `Sulfuras, Hand of Ragnaros` 가 아니면,
                - `item` 의 `quality` 를 1 감소시킴.
    - `item`의 이름이  `Aged Brie` 이거나 `Backstage passes to a TAFKAL80ETC concert`이고
        - `item`의 `quality`가 50보다 작으면
            - `quality` 를 1 증가시키고
            - 만약 이름이 `Backstage passes to a TAFKAL80ETC concert` 이고
                - `sellIn` 이 11보다 작으면
                    - `quality` 가 50보다 작을 때
                        - `quality` 를 1 증가시킴
                - `sellIn` 이 6보다 작으면
                    - `quality` 가 50보다 작을 때
                        - `quality` 를 1 증가시킴        
        
    - 만약 `item` 의 이름이 `Sulfuras, Hand of Ragnaros`이 아니면
        - `item` 의 `sellIn` 을 1 감소시킴            
    
    - 만약 `sellIn` 이 0보다 작다면
        - 이름이 `Aged Brie`가 아니면
            - 이름이 `Backstage passes to a TAFKAL80ETC concert`가 아니면
                - `item` 의 `quality` 가 0보다 크면
                    - 이름이 `Sulfuras, Hand of Ragnaros`가 아니면
                        - `quality` 를 1 감소시킴
            - 이름이 `Backstage passes to a TAFKAL80ETC concert`이면
                - `quality` 는 0이다
        - 이름이 `Aged Brie`이면
            - `quality` 가 50보다 작을 때
                - `quality` 를 1 증가시킨다. 
                

### updateQuality() 분석 (simple ver.)

- 이름이 3가지 case가 아닌 경우
     - `sellIn` 이 0과 같거나 작은 경우
          - `quality` 가 2이상인 경우
              - `quality` 를 2 감소
          - `quality` 가 0이하인 경우
     - `sellIn` 이 0보다 큰 경우
          - `quality` 가 0보다 큰 경우
              - `quality` 를 1 감소
          - `quality` 가 0이하인 경우
     - `sellIn` 을 1 감소
- 이름이 `Aged Brie`인 경우
     - `sellIn` 이 0이하인 경우
          - `quality` 가 49보다 작은 경우 
              - `quality` 를 2 증가
          - `quality` 가 49인 경우
              - `quality`  = 50
          - `quality` 가 50이상인 경우
              - `quality` 는 그대로
     - `sellIn` 이 0보다 큰 경우
          - `quality` 가 50보다 작은 경우
              - `quality` 는 1 증가
     - `sellIn` 을 1 감소
- 이름이 `Backstage passes to a TAFKAL80ETC concert`인 경우
     - `sellIn` 이 11이상인 경우
          - `quality` 가 50보다 작은 경우
              - `quality` 를 1 증가
     - `sellIn` 이 6이상 이고 11보다 작은 경우
          - `quality` 가 49보다 작은 경우
              - `quality` 를 2 증가
          - `quality` 가 49인 경우 
              - `quality` = 50
          - `quality` 가 50이상인 경우
              - `quality` 는 그대로
     - `sellIn` 이 6보다 작고 0보다 큰 경우
          - `quality` 가 48보다 작은 경우
              - `quality` 를 3 증가
          - `quality` 가 48, 49인 경우
              - `quality`  = 50
          - `quality` 가 50이상인 경우
              - `quality` 는 그대로
     - `sellIn` 이 0이하인 경우 
          - `quality`  = 0 
     - `sellIn` 을 1 감소

- 이름이 `Sulfuras, Hand of Ragnaros`인 경우 
     - 아무것도 실행하지 않음
