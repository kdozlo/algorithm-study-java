--오프라인/온라인 판매 데이터 통합하기
--https://school.programmers.co.kr/learn/courses/30/lessons/131537

    select
        DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    from
        ONLINE_SALE ons
    where
        year(sales_date) = 2022 and month(sales_date) = 3
union
    select
        DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as SALES_DATE,
        PRODUCT_ID,
        null as 'user_id',
        SALES_AMOUNT
    from
        OFFLINE_SALE
    where
        year(sales_date) = 2022 and month(sales_date) = 3
order by
    sales_date, product_id, user_id
;