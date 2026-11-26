import type { BookModel } from '../model/BookModel.ts';

interface BookResponse {
    content: BookModel[];
    page: {
        totalElements: number;
        totalPages: number;
    }
}

export const bookService =  {
    // All the services regarding books

    async getBooks(pageNo: number, pageSize: number): Promise<BookResponse> {
        const response = await fetch(
            `http://localhost:8080/api/books?pageNo=${pageNo}&pageSize=${pageSize}`
        );
        if (!response.ok) {
            throw new Error("Fail to fetch books");
        }
        return await response.json();
    }
}