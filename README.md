# ajou-dirtycode
## Dirty code for refactoring 과정
이 코드는 크게 세 부분으로 나뉜다. 
            if (!items[i].name.equals("Aged Brie") ...
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { ...         
	    if (items[i].sellIn < 0) { ...
첫번째 부분과 세번째 부분이 비슷한 부분이 많아 합쳐본다.

### 첫번째 부분
1.             if(!items) 
를 if invert 시킨다.

2. for을 foreach로 변경한다.

3.          item.quality = item.quality + 1;
            item.quality = item.quality - 1;
를

            item.quality += 1;
            item.quality -= 1;
로 변경한다

4.            if (items[i].name.equals("Aged Brie")
                    || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
를 if, else if두개로 나누기

5. Aged와 backstage에서 name.equalsBackstage 비교하는 부분이 중복되므로 없애기

6.                 if (items[i].quality > 0) {
부분을 sulfuras if 부분안에 넣기

7. sulfuras를 else if 로 합치기

8.                if (item.quality < 50) { 
따로 if문으로 빼기

### 세번째 부분
9.             if(!item)
을 if invert 시킨다.

10. backstage를 else if 로 합치기

11.                     if (items[i].quality > 0) {
와

                        if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
위치 바꾸기

12.                 if (items[i].name.equals("Aged Brie")) {

                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                } else {
                }
형태로 바꾸기

13.             if (items[i].sellIn < 0) {
if name.equals 안으로 넣기

14.                     if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;////////////8  line21
                    }
increaseItemQuality함수로 빼기

15.                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;///////////6
                    }
decreaseItemQuality함수로 빼기

### 두번째 부분
16.             if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            } else {
                items[i].sellIn = items[i].sellIn - 1;/////////5
            }
첫번째 세번째 합치기 위해서 위 코드를 맨위로 올리고 첫번째 if문에 sellin 비교문의 숫자를 10과 5로 변경

17. 첫번째와 세번째 두 비교문을 합치기



