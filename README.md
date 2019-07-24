# ajou-dirtycode


1. for문을 for each로 간편화 해주었습니다

 ```
 for (int i = 0; i < items.length; i++)
 >>>> 
 for (Item item : items)
  ```
 
 
 2. 간단한 식들을 추출해서 메소드화 시켜주었습니다
 
  ```
 item.name.equals("Sulfuras, Hand of Ragnaros"); 
 >>>> 
 private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
  ```
    
		
3. for 문 안에 있는 4가지 if, else, if, if문 안에 있는 내용들을 if,if 로 줄이고, 메소드로 추출해주었습니다

 ```
for (Item item : items) {

            ChecktheName(item);

            if (!isSulfuras(item)) {
                SellInDown_1(item);
            }

            if (item.sellIn < 0) {
                SellInLowerThanZero(item);
            }
        }
  ```
 
 4. 의미없는 수식을 정리해주었습니다

  ```
 item.quality = item.quality - item.quality;
 >>>> item.quality = 0;
  ```
 
 5. 분기별로 나뉜 메소드들에 조건문이 너무 많을경우 다시 새 메소드로 추출해주었습니다
  ```
    private void QualityLowerThan50(Item item) {
        if (item.quality < 50) {
            QualityUp_1(item);
            BackstageCase(item);
        }
    }

    private void BackstageCase(Item item) {
        if (isBackstage(item)) {
                    QualityUp_BySellIn(item);
        }
    } 
 ```

6. 중복되는 if문을 and연산자로 합쳐주었습니다
```
    if (item.sellIn < 11) {
         if (item.quality < 50) {
              QualityUp_1(item);
        }
            
    >>>>>

    if (item.sellIn < 11 && item.quality < 50){
         QualityUp_1(item);
        }
```

7. 중복되는 코드는 파라미터 값을 달리해서 새 메소드로 추출했습니다
```
    if (item.sellIn < 11 && item.quality < 50){
         QualityUp_1(item);
    }

    if (item.sellIn < 6 && item.quality < 50){
         QualityUp_1(item);
    }

    >>>>>

    private void QualityUp_BySellIn(Item item) {
            QualityUp_with_Sellln_amount(item, 11);
            QualityUp_with_Sellln_amount(item, 6);
    }

     private void QualityUp_with_Sellln_amount(Item item, int i) {
        if (item.sellIn < i && item.quality < 50) {
            QualityUp_1(item);
        }
     }
```