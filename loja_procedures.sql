SELECT * FROM promocao;
/* PROCEDURES DA MASSA */

-- PUXAR TODAS AS VENDAS DOS ULTIMOS 6 MESES DA EMPRESA 
DELIMITER $$
CREATE PROCEDURE PROC_VENDAS_ULTIMOS_MESES (
IN param_id int
)
BEGIN
	SELECT MONTH(data_criacao) as 'mes', SUM(quant_vendidos) as 'total_vendas' 
	FROM promocao 
	WHERE MONTH(data_criacao) > MONTH(DATE_SUB(current_date(), INTERVAL 6 MONTH)) AND empresa_id = param-_id
	GROUP BY MONTH(data_criacao);
END $
DELIMITER ;

-- PUXANDO [ Quant. promocoes, Total de vendas, Vendas do mês atual]
DELIMITER $
CREATE PROCEDURE PROC_ESTATISTICAS_LOJA(
IN param_id int
)
BEGIN
	SELECT t1.quant_promocoes , t1.total_vendas , t2.vendas_mes_atual
	FROM (SELECT count(id) as quant_promocoes, sum(quant_vendidos) as total_vendas
			FROM promocao
			WHERE empresa_id = param_id) t1
	JOIN (SELECT sum(quant_vendidos) as vendas_mes_atual
			FROM promocao 
			WHERE empresa_id = param_id and MONTH(data_criacao) = MONTH(current_date())) t2;
END $
DELIMITER ;



        
        
        
        
        