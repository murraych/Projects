SELECT 
        acc.*
FROM 
        accounts AS acc
        JOIN users
        ON users.user_id = acc.user_id
WHERE
        users.username = 'user';
        
INSERT INTO 
                transfers (transfer_type_id, transfer_status_id, account_from,account_to,amount)
                VALUES (1, 2, 2, 1, 150);
                        
                        
 DROP TABLE transfers;