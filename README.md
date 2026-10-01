# employee-management

docker exec -it employee-management-postgres psql -U root -d employee_management


# create the container image commands

docker rm -f employee-management-postgres

docker volume ls

docker run -d \
  --name employee-management-postgres \
  -e POSTGRES_USER=root \
  -e POSTGRES_PASSWORD=root \
  -e POSTGRES_DB=employee_management \
  -p 5432:5432 \
  -v devcontainer_postgres-data:/var/lib/postgresql/data \
  postgres:16

  docker start employee-management-postgres