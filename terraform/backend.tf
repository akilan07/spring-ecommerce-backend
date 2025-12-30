terraform {
  backend "s3" {
    bucket         = "my-ecom-app-terraform-state-bucket"
    key            = "env/prod/terraform.tfstate"
    region         = "ap-south-1"
    dynamodb_table = "terraform-locks"
    encrypt        = true
  }
}