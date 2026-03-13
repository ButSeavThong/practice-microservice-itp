
INSERT INTO account_types (account_type_id, account_type_code)
VALUES
    (gen_random_uuid(), 'SAVING'),
    (gen_random_uuid(), 'PAYROLL'),
    (gen_random_uuid(), 'LOAN'),
    (gen_random_uuid(), 'CHECKING');
